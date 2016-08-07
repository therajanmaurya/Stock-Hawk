package rajan.udacity.stock.hawk.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Stock;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public interface StocksService {

    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots")
    Observable<List<Stock>> getStocks();

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static StocksService newStocksService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(StocksService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(StocksService.class);
        }
    }
}
