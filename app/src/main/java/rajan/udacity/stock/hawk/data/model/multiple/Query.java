package rajan.udacity.stock.hawk.data.model.multiple;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 07/08/16.
 */
public class Query implements Parcelable {

    public static final Parcelable.Creator<Query> CREATOR = new Parcelable.Creator<Query>() {
        @Override
        public Query createFromParcel(Parcel source) {
            return new Query(source);
        }

        @Override
        public Query[] newArray(int size) {
            return new Query[size];
        }
    };
    @SerializedName("count")
    Integer mCount = 0;
    @SerializedName("created")
    String mCreated;
    @SerializedName("lang")
    String mLang;
    @SerializedName("results")
    Result mResult = new Result();

    public Query() {
    }

    protected Query(Parcel in) {
        this.mCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mCreated = in.readString();
        this.mLang = in.readString();
        this.mResult = in.readParcelable(Result.class.getClassLoader());
    }

    public Integer getCount() {
        return mCount;
    }

    public void setCount(Integer count) {
        mCount = count;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

    @Override
    public String toString() {
        return "Query{" +
                "mCount=" + mCount +
                ", mCreated='" + mCreated + '\'' +
                ", mLang='" + mLang + '\'' +
                ", mResult=" + mResult +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mCount);
        dest.writeString(this.mCreated);
        dest.writeString(this.mLang);
        dest.writeParcelable(this.mResult, flags);
    }
}
