package rajan.udacity.stock.hawk.data.remote;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Rajan Maurya on 15/08/16.
 */
public class UrlBuilder {

    StringBuilder urlStringBuilder = new StringBuilder();


    public void addYahooBaseUrl() {
        try{
            // Base URL for the Yahoo query
            urlStringBuilder.append("https://query.yahooapis.com/v1/public/yql?q=");
            urlStringBuilder.append(URLEncoder
                    .encode("select * from yahoo.finance.quotes where symbol " + "in (", "UTF-8"));
            urlStringBuilder.append(
                    URLEncoder.encode("\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
