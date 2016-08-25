package rajan.udacity.stock.hawk.util;

import java.util.Locale;

import rajan.udacity.stock.hawk.data.remote.UrlBuilder;

/**
 * Created by Rajan Maurya on 25/08/16.
 */
public class Utils {

    public static String getYahooStocksQuery() {
        return UrlBuilder.queryBuilder(
                Constants.YAHOO_STOCK_SYMBOL,
                Constants.APPLE_STOCK_SYMBOL,
                Constants.GOOGLE_STOCK_SYMBOL,
                Constants.MICROSOFT_STOCK_SYMBOL);
    }

    public static String getSingleStockQuery(String query) {
        String symbol = String.format(Locale.ENGLISH, "\"%s\"", query);
        return UrlBuilder.queryBuilder("\"GOOG\"");
    }
}
