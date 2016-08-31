package rajan.udacity.stock.hawk.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import rajan.udacity.stock.hawk.data.local.DatabaseHelper;
import rajan.udacity.stock.hawk.data.local.PreferencesHelper;
import rajan.udacity.stock.hawk.data.model.multiple.Stocks;
import rajan.udacity.stock.hawk.data.model.single.Stock;
import rajan.udacity.stock.hawk.data.remote.StocksService;
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

    public Observable<Stocks> syncStocks(String query) {
        return mStocksService.getStocks(query)
                .concatMap(new Func1<Stocks, Observable<? extends Stocks>>() {
                    @Override
                    public Observable<? extends Stocks> call(Stocks stock) {
                        return mDatabaseHelper.setStocks(stock);
                    }
                });
    }

    public Observable<Stock> syncStock(String query) {
        return mStocksService.getStock(query)
                .concatMap(new Func1<Stock, Observable<? extends Stock>>() {
                    @Override
                    public Observable<? extends Stock> call(Stock stock) {
                        if (stock.getQuery().getResult().getQuote().getAsk() == null) {
                            return Observable.just(stock);
                        } else {
                            return mDatabaseHelper.setStock(stock);
                        }
                    }
                });
    }

    public Observable<Stocks> getStocks() {
        return mDatabaseHelper.getStocks();
    }

    public Observable<Stocks> deleteStock(String symbol) {
        return mDatabaseHelper.deleteStock(symbol);
    }

    public Observable<Boolean> getChangeInPercentInPref() {
        return getPreferencesHelper().getChangeInPercent();
    }

    public Observable<Boolean> updateChangeInPercentInPref() {
        return getPreferencesHelper().updateChangeInPercentInPref();
    }

    public Observable<ResponseBody> getFinanceChartData(String symbol) {
        return mStocksService.getFinanceChartData(symbol);
    }
}
