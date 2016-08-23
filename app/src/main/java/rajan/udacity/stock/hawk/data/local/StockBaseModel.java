package rajan.udacity.stock.hawk.data.local;

import com.google.gson.Gson;

import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Rajan Maurya on 23/06/16.
 */
public class StockBaseModel extends BaseModel {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
