package rajan.udacity.stock.hawk.ui.stockgraph;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import rajan.udacity.stock.hawk.R;
import rajan.udacity.stock.hawk.ui.base.BaseActivity;
import rajan.udacity.stock.hawk.util.ActivityUtils;
import rajan.udacity.stock.hawk.util.Constants;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class StockGraphActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_container);


        final Intent intent = getIntent();
        String symbol = intent.getStringExtra(Constants.SYMBOL);

        //Setting the Fragment to FrameLayout
        StockGraphFragment mainFragment = (StockGraphFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_container);
        if (mainFragment == null) {
            // Create the fragment
            mainFragment = StockGraphFragment.newInstance(symbol);
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), mainFragment, R.id.frame_container);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}