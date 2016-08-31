package rajan.udacity.stock.hawk.ui.stockgraph;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartCallBack;
import rajan.udacity.stock.hawk.ui.base.BaseActivity;
import rajan.udacity.stock.hawk.util.Constants;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class StockGraphFragment extends Fragment implements StockGraphMvpView {

    private static final String LOG_TAG = StockGraphFragment.class.getSimpleName();

    @Inject
    StockGraphPresenter mStockGraphPresenter;

    private String mSymbol;


    public static StockGraphFragment newInstance(String symbol) {
        StockGraphFragment fragment = new StockGraphFragment();
        Bundle args = new Bundle();
        args.putString(Constants.SYMBOL, symbol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseActivity)getActivity()).activityComponent().inject(this);
        if (getArguments() != null) {
            mSymbol = getArguments().getString(Constants.SYMBOL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stocks_graph, container, false);

        ButterKnife.bind(this, rootView);
        mStockGraphPresenter.attachView(this);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mStockGraphPresenter.loadFinanceChartData(mSymbol);
    }

    @Override
    public void showProgressBar(Boolean show) {

    }

    @Override
    public void showFinanceChartData(FinanceChartCallBack financeChartCallBack) {
        Log.d(LOG_TAG, financeChartCallBack.getMeta().getCompanyName());
    }

    @Override
    public void showError() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mStockGraphPresenter.detachView();

    }
}
