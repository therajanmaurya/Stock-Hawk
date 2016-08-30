package rajan.udacity.stock.hawk.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.data.SyncService;
import rajan.udacity.stock.hawk.data.local.DatabaseHelper;
import rajan.udacity.stock.hawk.data.local.PreferencesHelper;
import rajan.udacity.stock.hawk.data.remote.StocksService;
import rajan.udacity.stock.hawk.injection.ApplicationContext;
import rajan.udacity.stock.hawk.injection.module.ApplicationModule;
import rajan.udacity.stock.hawk.ui.widget.ListRemoteViewFactory;
import rajan.udacity.stock.hawk.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    void inject(ListRemoteViewFactory listRemoteViewFactory);

    @ApplicationContext Context context();
    Application application();
    StocksService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
