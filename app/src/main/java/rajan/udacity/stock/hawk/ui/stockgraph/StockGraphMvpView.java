package rajan.udacity.stock.hawk.ui.stockgraph;

import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartCallBack;
import rajan.udacity.stock.hawk.ui.base.MvpView;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public interface StockGraphMvpView extends MvpView {

    void showProgressBar(Boolean show);

    void showFinanceChartData(FinanceChartCallBack financeChartCallBack);

    void initGraph();

    void showError();
}
