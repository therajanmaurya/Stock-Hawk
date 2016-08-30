package rajan.udacity.stock.hawk.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import rajan.udacity.stock.hawk.StockHawkApplication;
import rajan.udacity.stock.hawk.data.model.Quote;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class ListRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory,
        ListRemoteViewFactoryMvpView {

    @Inject
    ListRemoteViewFactoryPresenter mListRemoteViewFactoryPresenter;

    private Context mContext;
    private int mAppWidgetId;

    public ListRemoteViewFactory(Context applicationContext, Intent intent) {
        mContext = applicationContext;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void showStocks(List<Quote> quoteList) {
        Toast.makeText(mContext, quoteList.toString() , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStocksEmpty() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onCreate() {
        StockHawkApplication.get(mContext).getComponent().inject(this);
        mListRemoteViewFactoryPresenter.attachView(this);
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {
        mListRemoteViewFactoryPresenter.detachView();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        mListRemoteViewFactoryPresenter.loadStocks();
        return null;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
