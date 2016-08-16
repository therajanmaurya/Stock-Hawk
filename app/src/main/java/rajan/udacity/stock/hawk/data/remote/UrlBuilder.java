package rajan.udacity.stock.hawk.data.remote;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Rajan Maurya on 15/08/16.
 */
public class UrlBuilder {




    public static StringBuilder baseUrl() {

        StringBuilder baseUrlBuilder = new StringBuilder();
        // Base URL for the Yahoo query
        baseUrlBuilder.append("https://query.yahooapis.com/v1/public/yql");
        return baseUrlBuilder;
    }

    public static StringBuilder yahooSelectQuotesQuery() {

        StringBuilder queryBuilder = new StringBuilder();
        try {
            queryBuilder.append(URLEncoder
                    .encode("select * from yahoo.finance.quotes where symbol " + "in (", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return queryBuilder;
    }

    public StringBuilder addStockSymbol(String symbol) {
        
        StringBuilder stockSymbolBuilder = new StringBuilder();

        try {
            stockSymbolBuilder.append(URLEncoder.encode("\"" + symbol + "\")", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return stockSymbolBuilder;
    }
}
