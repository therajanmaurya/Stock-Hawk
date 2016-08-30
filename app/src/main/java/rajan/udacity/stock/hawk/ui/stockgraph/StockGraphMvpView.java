package rajan.udacity.stock.hawk.ui.stockgraph;

import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartData;
import rajan.udacity.stock.hawk.ui.base.MvpView;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public interface StockGraphMvpView extends MvpView {

    void showProgressBar(Boolean show);

    void showFinanceChartData(FinanceChartData financeChartData);

    void showError();
}
