package rajan.udacity.stock.hawk.ui.widget;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.ui.base.MvpView;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public interface ListRemoteViewFactoryMvpView extends MvpView {

    void showStocks(List<Quote> quoteList);

    void showStocksEmpty();

    void showError();
}
