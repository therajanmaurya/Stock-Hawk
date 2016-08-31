package rajan.udacity.stock.hawk.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.StockHawkApplication;
import rajan.udacity.stock.hawk.data.model.Quote;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class ListRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory,
        ListRemoteViewFactoryMvpView {

    private static final String LOG_TAG = ListRemoteViewFactory.class.getSimpleName();
    private final Object mObject;
    @Inject
    ListRemoteViewFactoryPresenter mListRemoteViewFactoryPresenter;
    private Context mContext;
    private int mAppWidgetId;
    private List<Quote> mQuoteList;

    public ListRemoteViewFactory(Context applicationContext, Intent intent) {
        mContext = applicationContext;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        mQuoteList = new ArrayList<>();
        mObject = new Object();
    }

    @Override
    public void onCreate() {
        StockHawkApplication.get(mContext).getComponent().inject(this);
        mListRemoteViewFactoryPresenter.attachView(this);
    }

    @Override
    public void onDataSetChanged() {
        mListRemoteViewFactoryPresenter.loadStocks();
        synchronized (mObject) {
            try {
                // Calling wait() will block this thread until another thread
                // calls notify() on the object.
                mObject.wait();
            } catch (InterruptedException e) {
                // Happens if someone interrupts your thread.
            }
        }
    }

    @Override
    public RemoteViews getViewAt(int position) {

        Quote quote = mQuoteList.get(position);

        final int itemId = R.layout.appwidget_collection_item;
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), itemId);
        rv.setTextViewText(R.id.stock_symbol, quote.getMsymbol());
        rv.setTextViewText(R.id.bid_price, String.valueOf(quote.getBid()));
        rv.setTextViewText(R.id.change, quote.getChangeinPercent());

        final Intent viewIntent = new Intent();
        final Bundle extras = new Bundle();
        extras.putString("Symbol", quote.getMsymbol());
        viewIntent.putExtras(extras);
        rv.setOnClickFillInIntent(R.id.widget_item, viewIntent);

        Log.d(LOG_TAG, quote.getMsymbol());

        return rv;
    }

    @Override
    public void showStocks(List<Quote> quoteList) {
        mQuoteList = quoteList;
        synchronized (mObject) {
            mObject.notify();
        }
    }

    @Override
    public void showStocksEmpty() {

    }

    @Override
    public void showError() {
        Toast.makeText(mContext, mContext.getString(R.string.error_loading_stocks),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        mListRemoteViewFactoryPresenter.detachView();
    }

    @Override
    public int getCount() {
        return mQuoteList.size();
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
