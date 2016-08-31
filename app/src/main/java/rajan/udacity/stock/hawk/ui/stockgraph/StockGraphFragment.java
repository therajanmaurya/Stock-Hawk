package rajan.udacity.stock.hawk.ui.stockgraph;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartCallBack;
import rajan.udacity.stock.hawk.ui.base.BaseActivity;
import rajan.udacity.stock.hawk.util.Constants;
import rajan.udacity.stock.hawk.util.Utils;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class StockGraphFragment extends Fragment implements StockGraphMvpView,
        OnChartGestureListener, OnChartValueSelectedListener {

    private static final String LOG_TAG = StockGraphFragment.class.getSimpleName();

    @BindView(R.id.linechart)
    LineChart mChart;

    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;

    @Inject
    StockGraphPresenter mStockGraphPresenter;

    private String mSymbol;
    private List<String> lables;
    private List<Float> values;

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
        lables = new ArrayList<>();
        values = new ArrayList<>();
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

        initGraph();

        mStockGraphPresenter.loadFinanceChartData(mSymbol);

        return rootView;
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            lables = savedInstanceState.getStringArrayList(Constants.GRAPH_LABLES);
            values = (List<Float>) savedInstanceState.getSerializable(Constants.GRAPH_VALUES);
        }
    }

    @Override
    public void initGraph() {
        mChart.setOnChartGestureListener(this);
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawGridBackground(false);
        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setVisibleXRangeMaximum(20);
        mChart.setPinchZoom(true);
        mChart.getAxisRight().setEnabled(false);
        mChart.setDescription("");
        mChart.setNoDataText("");
        mChart.setNoDataTextDescription("");
        mChart.invalidate();
    }

    @Override
    public void showFinanceChartData(FinanceChartCallBack financeChartCallBack) {
        getActivity().setTitle(financeChartCallBack.getMeta().getCompanyName());
        lables = Utils.getPlottingLables(getActivity(), financeChartCallBack.getSeries());
        values = Utils.getPlottingValues(financeChartCallBack.getSeries());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                ArrayList<Entry> val = new ArrayList<Entry>();
                for (int i = 0; i < lables.size(); i++) {
                    val.add(new Entry(values.get(i), i));
                }

                LineDataSet set = new LineDataSet(val, "Stocks Data");

                set.enableDashedLine(10f, 5f, 0f);
                set.enableDashedHighlightLine(10f, 5f, 0f);
                set.setColor(Color.BLACK);
                set.setCircleColor(Color.BLACK);
                set.setLineWidth(1f);
                set.setCircleRadius(3f);
                set.setDrawCircleHole(false);
                set.setValueTextSize(9f);
                set.setDrawFilled(true);

                ArrayList<String> dates = new ArrayList<String>();
                for (int i = 0; i < lables.size(); i++) {
                    dates.add(i, lables.get(i));
                }
                LineData data = new LineData(lables, set);
                mChart.setData(data);
                mChart.invalidate();

            }
        });
    }


    @Override
    public void showProgressBar(Boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), getResources()
                .getString(R.string.failed_to_load_finanace_chart_data), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mStockGraphPresenter.detachView();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList(Constants.GRAPH_LABLES, (ArrayList<String>) lables);
        savedInstanceState.putSerializable(Constants.GRAPH_VALUES, (Serializable) values);


    }

    @Override
    public void onChartGestureStart(MotionEvent me,
                                    ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me,
                                  ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
