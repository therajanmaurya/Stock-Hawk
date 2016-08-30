package rajan.udacity.stock.hawk.ui.stockgraph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rajan.udacity.stock.hawk.util.Constants;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class StockGraphFragment extends Fragment {


    public static StockGraphFragment newInstance(String symbol) {
        StockGraphFragment fragment = new StockGraphFragment();
        Bundle args = new Bundle();
        args.putString(Constants.SYMBOL, symbol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
