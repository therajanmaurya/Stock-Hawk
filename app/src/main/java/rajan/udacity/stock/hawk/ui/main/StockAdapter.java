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
import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.data.model.Stock;
import rajan.udacity.stock.hawk.touch_helper.ItemTouchHelperAdapter;
import rajan.udacity.stock.hawk.touch_helper.ItemTouchHelperViewHolder;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder>
        implements ItemTouchHelperAdapter {

    private Stock mStocks;

    private DismissStockListener mDismissStockListener;

    @Inject
    public StockAdapter() {
        mStocks = new Stock();
    }

    public void setStocks(Stock stocks) {
        mStocks = stocks;
    }

    public Stock getStocks() {
        return mStocks;
    }

    public StockAdapter setOnDismissStockListener(DismissStockListener listener) {
        mDismissStockListener = listener;
        return this;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stock, parent, false);
        return new StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StockViewHolder holder, int position) {
        Quote quote = mStocks.getQuery().getResult().getQuote().get(position);

        holder.tv_stock_symbol.setText(quote.getMsymbol());
        holder.tv_bid_price.setText(String.valueOf(quote.getBid()));
        holder.tv_change.setText(quote.getChangeinPercent());
    }

    @Override
    public int getItemCount() {
        return mStocks.getQuery().getResult().getQuote().size();
    }

    @Override
    public void onItemDismiss(int position) {
        mDismissStockListener.onStockDismiss(mStocks.getQuery()
                .getResult().getQuote().get(position).getMsymbol());
        notifyItemRemoved(position);
    }

    class StockViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        @BindView(R.id.stock_symbol) TextView tv_stock_symbol;
        @BindView(R.id.bid_price) TextView tv_bid_price;
        @BindView(R.id.change) TextView tv_change;

        public StockViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onItemSelected() {
            //itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            //itemView.setBackgroundColor(0);
        }
    }

    public interface DismissStockListener {
        void onStockDismiss(String symbol);
    }
}
