package rajan.udacity.stock.hawk.data.local;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.data.model.Quote_Table;
import rajan.udacity.stock.hawk.data.model.Stock;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

@Singleton
public class DatabaseHelper {

    @Inject
    public DatabaseHelper() {
    }


    public Observable<Stock> setStocks(final Stock stock) {
        return Observable.defer(new Func0<Observable<Stock>>() {
            @Override
            public Observable<Stock> call() {

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

    public Observable<Stock> getStocks() {
        return Observable.defer(new Func0<Observable<Stock>>() {
            @Override
            public Observable<Stock> call() {

                List<Quote> quotes = SQLite.select()
                        .from(Quote.class)
                        .queryList();

                Stock stock = new Stock();
                stock.getQuery().getResult().setQuote(quotes);

                return Observable.just(stock);
            }
        });
    }

    public Observable<Stock> deleteStock(final String symbol) {
        return Observable.defer(new Func0<Observable<Stock>>() {
            @Override
            public Observable<Stock> call() {

                Delete.table(Quote.class,
                        Quote_Table.msymbol.eq(symbol));

                return getStocks();
            }
        });
    }

}
