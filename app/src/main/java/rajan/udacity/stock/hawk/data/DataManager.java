package rajan.udacity.stock.hawk.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import rajan.udacity.stock.hawk.data.local.DatabaseHelper;
import rajan.udacity.stock.hawk.data.local.PreferencesHelper;
import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.data.remote.StocksService;
import rajan.udacity.stock.hawk.data.remote.UrlBuilder;
import rajan.udacity.stock.hawk.util.Constants;
import rx.Observable;
import rx.functions.Func1;

@Singleton
public class DataManager {

    private final StocksService mStocksService;
    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(StocksService stocksService,
                       PreferencesHelper preferencesHelper,
                       DatabaseHelper databaseHelper) {
        mStocksService = stocksService;
        mPreferencesHelper = preferencesHelper;
        mDatabaseHelper = databaseHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    public Observable<Stock> syncStocks() {
        return mStocksService.getStocks(getYahooStocksQuery())
                .concatMap(new Func1<Stock, Observable<? extends Stock>>() {
                    @Override
                    public Observable<? extends Stock> call(Stock stock) {
                        return mDatabaseHelper.setStocks(stock);
                    }
                });
    }

    public Observable<Stock> getStocks() {
        return mDatabaseHelper.getStocks();
    }

    public Observable<Boolean> deleteStock(String symbol) {
        return mDatabaseHelper.deleteStock(symbol);
    }

    public String getYahooStocksQuery( ) {
        return UrlBuilder.queryBuilder(
                Constants.YAHOO_STOCK_SYMBOL,
                Constants.APPLE_STOCK_SYMBOL,
                Constants.GOOGLE_STOCK_SYMBOL,
                Constants.MICROSOFT_STOCK_SYMBOL);
    }
}
