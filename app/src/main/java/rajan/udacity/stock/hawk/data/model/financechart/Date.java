package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class Date implements Parcelable {

    @SerializedName("min")
    Double mMin;

    @SerializedName("max")
    Double mMax;

    public Double getMin() {
        return mMin;
    }

    public void setMin(Double min) {
        mMin = min;
    }

    public Double getMax() {
        return mMax;
    }

    public void setMax(Double max) {
        mMax = max;
    }

    @Override
    public String toString() {
        return "Date{" +
                "mMin=" + mMin +
                ", mMax=" + mMax +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mMin);
        dest.writeValue(this.mMax);
    }

    public Date() {
    }

    protected Date(Parcel in) {
        this.mMin = (Double) in.readValue(Double.class.getClassLoader());
        this.mMax = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Date> CREATOR = new Parcelable.Creator<Date>() {
        @Override
        public Date createFromParcel(Parcel source) {
            return new Date(source);
        }

        @Override
        public Date[] newArray(int size) {
            return new Date[size];
        }
    };
}
