package rajan.udacity.stock.hawk.ui.main;

import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showStocks(Stock stock);

    void showStocksEmpty();

    void showMaterialDialogAddStock();

    void showError();

}
