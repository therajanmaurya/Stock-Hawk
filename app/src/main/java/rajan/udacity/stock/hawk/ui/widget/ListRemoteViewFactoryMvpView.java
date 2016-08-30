package rajan.udacity.stock.hawk.ui.widget;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Quote;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public interface ListRemoteViewFactoryMvpView {

    void showStocks(List<Quote> quoteList);
}
