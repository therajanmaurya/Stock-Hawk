package rajan.udacity.stock.hawk.data.model.multiple;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class Stocks implements Parcelable {

    public static final Parcelable.Creator<Stocks> CREATOR = new Parcelable.Creator<Stocks>() {
        @Override
        public Stocks createFromParcel(Parcel source) {
            return new Stocks(source);
        }

        @Override
        public Stocks[] newArray(int size) {
            return new Stocks[size];
        }
    };
    @SerializedName("query")
    Query mQuery = new Query();

    public Stocks() {
    }

    protected Stocks(Parcel in) {
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
        return "Stocks{" +
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


