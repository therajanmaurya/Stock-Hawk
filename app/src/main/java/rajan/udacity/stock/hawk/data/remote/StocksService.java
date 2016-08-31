package rajan.udacity.stock.hawk.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import rajan.udacity.stock.hawk.BuildConfig;
import rajan.udacity.stock.hawk.data.ApiEndPoint;
import rajan.udacity.stock.hawk.data.model.multiple.Stocks;
import rajan.udacity.stock.hawk.data.model.single.Stock;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface StocksService {

    String ENDPOINT = "https://query.yahooapis.com/v1/public/";
    String FINANCE_CART_API_ENDPOINT = "https://chartapi.finance.yahoo.com/instrument/1.0/";

    @GET(ApiEndPoint.YAHOO_QUERY_LANGUAGE + ApiEndPoint.RESPONSE_FORMAT)
    Observable<Stocks> getStocks(@Query(value = "q", encoded = true) String q);

    @GET(ApiEndPoint.YAHOO_QUERY_LANGUAGE + ApiEndPoint.RESPONSE_FORMAT)
    Observable<Stock> getStock(@Query(value = "q", encoded = true) String q);

    @GET(FINANCE_CART_API_ENDPOINT + "{symbol}/" + "chartdata;type=quote;range=5y/json" )
    Observable<ResponseBody> getFinanceChartData(@Path("symbol") String symbol);

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static StocksService newStocksService() {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(StocksService.ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(StocksService.class);
        }
    }
}
