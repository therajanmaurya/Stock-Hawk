package rajan.udacity.stock.hawk.ui.main;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showStocks(List<Stock> ribots);

    void showStocksEmpty();

    void showError();

}
