package rajan.udacity.stock.hawk.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.data.model.Quote;
import rajan.udacity.stock.hawk.touch_helper.ItemTouchHelperAdapter;
import rajan.udacity.stock.hawk.touch_helper.ItemTouchHelperViewHolder;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder>
        implements ItemTouchHelperAdapter {

    private List<Quote> mQuoteList;

    private DismissAndOnClickItemStockListener mDismissAndOnClickItemStockListener;

    private Boolean changeInPercent = false;

    @Inject
    public StockAdapter() {
        mQuoteList = new ArrayList<>();
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stock, parent, false);
        return new StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StockViewHolder holder, int position) {
        final Quote quote = mQuoteList.get(position);

        holder.tv_stock_symbol.setText(quote.getMsymbol());
        holder.tv_bid_price.setText(String.valueOf(quote.getBid()));

        if (changeInPercent) {
            holder.tv_change.setText(quote.getChangeinPercent());
        } else {
            holder.tv_change.setText(String.valueOf(quote.getChange()));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDismissAndOnClickItemStockListener.onItemClick(quote.getMsymbol());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        mDismissAndOnClickItemStockListener.onStockDismiss(mQuoteList.get(position).getMsymbol());
        notifyItemRemoved(position);
    }

    public void setStock(Quote quote) {
        mQuoteList.add(quote);
        notifyDataSetChanged();
    }

    public List<Quote> getStocks() {
        return mQuoteList;
    }

    public String getStockSymbol(int position) {
        return mQuoteList.get(position).getMsymbol();
    }

    public void setStocks(List<Quote> quotes) {
        mQuoteList = quotes;
    }

    public StockAdapter setOnDismissStockListener(DismissAndOnClickItemStockListener listener) {
        mDismissAndOnClickItemStockListener = listener;
        return this;
    }

    public void setChangeInPercent(Boolean changeInPercent) {
        this.changeInPercent = changeInPercent;
        notifyDataSetChanged();
    }

    public interface DismissAndOnClickItemStockListener {
        void onStockDismiss(String symbol);
        void onItemClick(String symbol);
    }

    class StockViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        @BindView(R.id.stock_symbol)
        TextView tv_stock_symbol;
        @BindView(R.id.bid_price)
        TextView tv_bid_price;
        @BindView(R.id.change)
        TextView tv_change;

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
}
