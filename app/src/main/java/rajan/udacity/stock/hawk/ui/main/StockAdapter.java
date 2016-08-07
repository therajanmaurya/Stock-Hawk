package rajan.udacity.stock.hawk.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.model.Stock;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder> {

    private Stock mStocks;

    @Inject
    public StockAdapter() {
        mStocks = new Stock();
    }

    public void setStocks(Stock stocks) {
        mStocks = stocks;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stock, parent, false);
        return new StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StockViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class StockViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stock_symbol) TextView tv_stock_symbol;
        @BindView(R.id.bid_price) TextView tv_bid_price;
        @BindView(R.id.change) TextView tv_change;

        public StockViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
