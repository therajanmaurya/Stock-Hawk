package rajan.udacity.stock.hawk.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Quote;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class ListRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory,
        ListRemoteViewFactoryMvpView {


    private Context mContext;
    private int mAppWidgetId;

    public ListRemoteViewFactory(Context applicationContext, Intent intent) {
        mContext = applicationContext;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public RemoteViews getViewAt(int i) {
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

    @Override
    public void showStocks(List<Quote> quoteList) {

    }
}
