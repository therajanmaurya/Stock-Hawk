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
    public DataManager(StocksService stocksService, PreferencesHelper preferencesHelper,
                       DatabaseHelper databaseHelper) {
        mStocksService = stocksService;
        mPreferencesHelper = preferencesHelper;
        mDatabaseHelper = databaseHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    public Observable<Stock> syncStocks() {
        return null;
    }

    public Observable<List<Stock>> getStocks() {
        return null;
    }

}
