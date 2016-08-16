package rajan.udacity.stock.hawk.data.remote;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajan Maurya on 15/08/16.
 */
public class UrlBuilder {


    /**
     * This Method Make the base Url of the Request for Retrofit 2
     *
     * @return StringBuilder of the BaseUrl
     */
    public static StringBuilder baseUrl() {

        StringBuilder baseUrlBuilder = new StringBuilder();
        // Base URL for the Yahoo query
        baseUrlBuilder.append("https://query.yahooapis.com/v1/public");
        return baseUrlBuilder;
    }


    /**
     * This Method Add the Select Yahoo query to Request URl
     *
     * @return StringBuilder of the Yahoo Table Select Query
     */
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

    /**
     * This Method Add the Symbol to the Query
     *
     * @param symbol Symbol of the Stocks
     * @return StringBuilder of Stock Symbol
     */
    public StringBuilder addStockSymbol(String symbol) {

        StringBuilder stockSymbolBuilder = new StringBuilder();

        try {
            stockSymbolBuilder.append(URLEncoder.encode("\"" + symbol + "\")", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return stockSymbolBuilder;
    }


    /**
     * This method add the response type to Request Url
     *
     * @return StringBuilder
     */
    public static StringBuilder responseFormat() {

        StringBuilder responseFormatBuilder = new StringBuilder();
        // finalize the URL for the API query.
        responseFormatBuilder.append("&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables."
                + "org%2Falltableswithkeys&callback=");

        return responseFormatBuilder;
    }


    /**
     * This Method is building the Yahoo Table Query
     *
     * @param symbols Stocks Symbols
     * @return Yahoo Table Query
     */
    public String queryBuilder(String... symbols) {

        List<String> stocksSymbols = Arrays.asList(symbols);
        StringBuilder stringQueryBuilder = new StringBuilder();

        stringQueryBuilder.append(yahooSelectQuotesQuery());

        if (stocksSymbols.size() != 0) {
            for (int i = 0; i < stocksSymbols.size() ; ++i) {
                stringQueryBuilder.append(addStockSymbol(stocksSymbols.get(i)));
            }
        }

        stringQueryBuilder.append(responseFormat());

        return stringQueryBuilder.toString();
    }
}
