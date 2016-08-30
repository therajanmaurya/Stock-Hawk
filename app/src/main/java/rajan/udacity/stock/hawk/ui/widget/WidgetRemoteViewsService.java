package rajan.udacity.stock.hawk.ui.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class WidgetRemoteViewsService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ListRemoteViewFactory(this.getApplicationContext(), intent);
    }
}
