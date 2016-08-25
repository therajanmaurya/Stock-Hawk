package rajan.udacity.stock.hawk.data.local;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.data.model.Quote_Table;
import rajan.udacity.stock.hawk.data.model.multiple.Stocks;
import rajan.udacity.stock.hawk.data.model.single.Stock;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

@Singleton
public class DatabaseHelper {

    @Inject
    public DatabaseHelper() {
    }


    public Observable<Stocks> setStocks(final Stocks stock) {
        return Observable.defer(new Func0<Observable<Stocks>>() {
            @Override
            public Observable<Stocks> call() {

                List<Quote> quote = stock.getQuery().getResult().getQuote();
                Observable.from(quote)
                        .subscribe(new Action1<Quote>() {
                            @Override
                            public void call(Quote quote) {
                                quote.save();
                            }
                        });

                return Observable.just(stock);
            }
        });
    }

    public Observable<Stock> setStock(final Stock stock) {
        return Observable.defer(new Func0<Observable<Stock>>() {
            @Override
            public Observable<Stock> call() {

                Quote quote = stock.getQuery().getResult().getQuote();
                quote.save();

                return Observable.just(stock);
            }
        });
    }

    public Observable<Stocks> getStocks() {
        return Observable.defer(new Func0<Observable<Stocks>>() {
            @Override
            public Observable<Stocks> call() {

                List<Quote> quotes = SQLite.select()
                        .from(Quote.class)
                        .queryList();

                Stocks stock = new Stocks();
                stock.getQuery().getResult().setQuote(quotes);

                return Observable.just(stock);
            }
        });
    }

    public Observable<Stocks> deleteStock(final String symbol) {
        return Observable.defer(new Func0<Observable<Stocks>>() {
            @Override
            public Observable<Stocks> call() {

                Delete.table(Quote.class,
                        Quote_Table.msymbol.eq(symbol));

                return getStocks();
            }
        });
    }

}
