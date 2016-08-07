package rajan.udacity.stock.hawk.ui.main;

import android.graphics.Color;
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
import rajan.udacity.stock.hawk.data.model.Ribot;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.RibotViewHolder> {

    private List<Ribot> mRibots;

    @Inject
    public StockAdapter() {
        mRibots = new ArrayList<>();
    }

    public void setRibots(List<Ribot> ribots) {
        mRibots = ribots;
    }

    @Override
    public RibotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ribot, parent, false);
        return new RibotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RibotViewHolder holder, int position) {
        Ribot ribot = mRibots.get(position);
        holder.hexColorView.setBackgroundColor(Color.parseColor(ribot.profile().hexColor()));
        holder.nameTextView.setText(String.format("%s %s",
                ribot.profile().name().first(), ribot.profile().name().last()));
        holder.emailTextView.setText(ribot.profile().email());
    }

    @Override
    public int getItemCount() {
        return mRibots.size();
    }

    class RibotViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_hex_color) View hexColorView;
        @BindView(R.id.text_name) TextView nameTextView;
        @BindView(R.id.text_email) TextView emailTextView;

        public RibotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
