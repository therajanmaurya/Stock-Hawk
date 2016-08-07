package rajan.udacity.stock.hawk.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rajan.udacity.stock.hawk.data.local.DatabaseHelper;
import rajan.udacity.stock.hawk.data.local.PreferencesHelper;
import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.data.remote.StocksService;
import rx.Observable;

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

        String mQuery = "select+*+from+yahoo.finance.quotes+where+symbol+in+%28%22YHOO%22%2C%22AAPL%" +
                "22%2C%22GOOG%22%2C%22MSFT%22%2C%22ch%22%29&format=json&diagnostics=" +
                "true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

        return mStocksService.getStocks(mQuery);
    }

    public Observable<List<Stock>> getStocks() {
        return null;
    }

}
