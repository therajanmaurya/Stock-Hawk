package rajan.udacity.stock.hawk.data.remote;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Rajan Maurya on 15/08/16.
 */
public class UrlBuilder {




    public StringBuilder baseUrl() {

        StringBuilder baseUrlBuilder = new StringBuilder();
        // Base URL for the Yahoo query
        baseUrlBuilder.append("https://query.yahooapis.com/v1/public/yql");
            /*urlStringBuilder.append(
                    URLEncoder.encode("\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")", "UTF-8"));*/
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
}
