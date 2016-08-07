package rajan.udacity.stock.hawk.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rajan Maurya on 07/08/16.
 */
public class Query {

    @SerializedName("count")
    Integer mCount;

    @SerializedName("created")
    String mCreated;

    @SerializedName("lang")
    String mLang;

    @SerializedName("results")
    Result mResult;
}
