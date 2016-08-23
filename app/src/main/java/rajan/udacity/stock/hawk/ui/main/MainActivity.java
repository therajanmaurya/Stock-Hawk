package rajan.udacity.stock.hawk.ui.main;

import com.afollestad.materialdialogs.MaterialDialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.InputType;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.SyncService;
import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.touch_helper.SimpleItemTouchHelperCallback;
import rajan.udacity.stock.hawk.ui.base.BaseActivity;
import rajan.udacity.stock.hawk.util.DialogFactory;
import rajan.udacity.stock.hawk.util.NetworkUtil;

public class MainActivity extends BaseActivity implements MainMvpView, StockAdapter.DismissStockListener {

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


    @OnClick(R.id.fb_add_stock)
    void onClickAddStock() {
        if (NetworkUtil.isNetworkConnected(this)) {
            new MaterialDialog.Builder(this).title(R.string.symbol_search)
                    .content(R.string.content_test)
                    .inputType(InputType.TYPE_CLASS_TEXT)
                    .input(R.string.input_hint, R.string.input_prefill,
                            new MaterialDialog.InputCallback() {
                                @Override
                                public void onInput(MaterialDialog dialog, CharSequence input) {
                                    // On FAB click, receive user input. Make sure the stock doesn't
                                    // already exist in the DB and proceed accordingly

                                }
                            })
                    .show();

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
    public void showStocks(Stock stocks) {
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
        mStocksAdapter.setStocks(new Stock());
        mStocksAdapter.notifyDataSetChanged();
        Toast.makeText(this, R.string.empty_stocks, Toast.LENGTH_LONG).show();
    }
}
