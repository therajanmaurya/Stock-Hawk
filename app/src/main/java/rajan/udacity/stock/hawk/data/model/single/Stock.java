package rajan.udacity.stock.hawk.data.model.single;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class Stock implements Parcelable {

    public static final Creator<Stock> CREATOR = new Creator<Stock>() {
        @Override
        public Stock createFromParcel(Parcel source) {
            return new Stock(source);
        }

        @Override
        public Stock[] newArray(int size) {
            return new Stock[size];
        }
    };
    @SerializedName("query")
    Query mQuery = new Query();

    public Stock() {
    }

    protected Stock(Parcel in) {
        this.mQuery = in.readParcelable(Query.class.getClassLoader());
    }

    public Query getQuery() {
        return mQuery;
    }

    public void setQuery(Query query) {
        mQuery = query;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "mQuery=" + mQuery +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mQuery, flags);
    }
}


