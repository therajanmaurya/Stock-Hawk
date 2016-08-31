package rajan.udacity.stock.hawk.injection.component;

import dagger.Subcomponent;
import rajan.udacity.stock.hawk.injection.PerActivity;
import rajan.udacity.stock.hawk.injection.module.ActivityModule;
import rajan.udacity.stock.hawk.ui.main.MainActivity;
import rajan.udacity.stock.hawk.ui.stockgraph.StockGraphFragment;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(StockGraphFragment stockGraphFragment);

}
