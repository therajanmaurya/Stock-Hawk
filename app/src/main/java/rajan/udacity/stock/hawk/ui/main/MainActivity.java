package rajan.udacity.stock.hawk.ui.main;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.SyncService;
import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.touch_helper.SimpleItemTouchHelperCallback;
import rajan.udacity.stock.hawk.ui.base.BaseActivity;
import rajan.udacity.stock.hawk.ui.stockgraph.StockGraphActivity;
import rajan.udacity.stock.hawk.util.Constants;
import rajan.udacity.stock.hawk.util.DialogFactory;
import rajan.udacity.stock.hawk.util.NetworkUtil;

public class MainActivity extends BaseActivity implements
        MainMvpView, StockAdapter.DismissAndOnClickItemStockListener {

    private static final String EXTRA_TRIGGER_SYNC_FLAG =
            "rajan.udacity.stock.hawk.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @Inject
    MainPresenter mMainPresenter;

    @Inject
    StockAdapter mStocksAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    /**
     * Return an Intent to start this Activity.
     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
     * only be set to false during testing.
     */
    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    public void onItemClick(String symbol) {
        Intent intent = new Intent(this, StockGraphActivity.class);
        intent.putExtra(Constants.SYMBOL, symbol);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setAdapter(mStocksAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStocksAdapter.setOnDismissStockListener(this);
        mMainPresenter.attachView(this);
        mMainPresenter.loadStocks();

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mStocksAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncService.getStartIntent(this));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.loadChangeInPercent();
    }

    @OnClick(R.id.fb_add_stock)
    void onClickAddStock() {
        if (NetworkUtil.isNetworkConnected(this)) {
            showMaterialDialogAddStock();
        } else {
            Toast.makeText(this, getResources().getString(R.string.network_toast),
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onStockDismiss(String symbol) {
        mMainPresenter.deleteStock(symbol);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    /***** MVP View methods implementation *****/

    @Override
    public void showStocks(List<Quote> stocks) {
        mStocksAdapter.setStocks(stocks);
        mStocksAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_stocks))
                .show();
    }

    @Override
    public void showStocksEmpty() {
        List<Quote> quotes = new ArrayList<>();
        mStocksAdapter.setStocks(quotes);
        mStocksAdapter.notifyDataSetChanged();
        Toast.makeText(this, R.string.empty_stocks, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showStock(Quote quote) {
        mStocksAdapter.setStock(quote);
    }

    @Override
    public void showStockDoesNotExist() {
        Toast toast = Toast.makeText(this, getResources().getString(R.string.stock_does_not_exist),
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER, 0);
        toast.show();
    }

    @Override
    public void showMaterialDialogAddStock() {
        new MaterialDialog.Builder(this).title(R.string.symbol_search)
                .content(R.string.content_test)
                .positiveColorRes(R.color.white)
                .positiveColor(Color.WHITE)
                .theme(Theme.DARK)
                .backgroundColorRes(R.color.material_blue_grey_800)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(R.string.input_hint, R.string.input_prefill,
                        new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // On FAB click, receive user input. Make sure the stock doesn't
                                // already exist in the DB and proceed accordingly
                                if (checkSymbolExistOrNot(input.toString(),
                                        mStocksAdapter.getStocks())) {
                                    showStockAlreadyExist();
                                } else if (!input.toString().isEmpty()) {
                                    mMainPresenter.loadStock(input.toString());
                                }
                            }
                        })
                .show();
    }

    @Override
    public Boolean checkSymbolExistOrNot(String symbol, List<Quote> stock) {
        return mMainPresenter.checkStocksExistOrNot(symbol, stock);
    }

    @Override
    public void showStockAlreadyExist() {
        Toast toast = Toast.makeText(this, getResources().getString(R.string.stocks_already_exist),
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER, 0);
        toast.show();
    }

    @Override
    public void showChangeInPercent(Boolean changeInPercent) {
        mStocksAdapter.setChangeInPercent(changeInPercent);
    }

    @Override
    public void updateChangeInPercent(Boolean changeInPercent) {
        mStocksAdapter.setChangeInPercent(changeInPercent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_change_units) {
            mMainPresenter.updateChangeInPercent();
        }

        return super.onOptionsItemSelected(item);
    }
}
