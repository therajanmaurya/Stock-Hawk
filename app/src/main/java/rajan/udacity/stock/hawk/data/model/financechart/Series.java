package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class Series implements Parcelable {

    @SerializedName("Date")
    Double mDate;

    @SerializedName("close")
    Double mClose;

    @SerializedName("high")
    Double mHigh;

    @SerializedName("low")
    Double mLow;

    @SerializedName("mOpen")
    Double mOpen;

    @SerializedName("volume")
    Double mVolume;

    public Double getDate() {
        return mDate;
    }

    public void setDate(Double date) {
        mDate = date;
    }

    public Double getClose() {
        return mClose;
    }

    public void setClose(Double close) {
        mClose = close;
    }

    public Double getHigh() {
        return mHigh;
    }

    public void setHigh(Double high) {
        mHigh = high;
    }

    public Double getLow() {
        return mLow;
    }

    public void setLow(Double low) {
        mLow = low;
    }

    public Double getOpen() {
        return mOpen;
    }

    public void setOpen(Double open) {
        this.mOpen = open;
    }

    public Double getVolume() {
        return mVolume;
    }

    public void setVolume(Double volume) {
        mVolume = volume;
    }

    @Override
    public String toString() {
        return "Series{" +
                "mDate=" + mDate +
                ", mClose=" + mClose +
                ", mHigh=" + mHigh +
                ", mLow=" + mLow +
                ", mOpen=" + mOpen +
                ", mVolume=" + mVolume +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mDate);
        dest.writeValue(this.mClose);
        dest.writeValue(this.mHigh);
        dest.writeValue(this.mLow);
        dest.writeValue(this.mOpen);
        dest.writeValue(this.mVolume);
    }

    public Series() {
    }

    protected Series(Parcel in) {
        this.mDate = (Double) in.readValue(Double.class.getClassLoader());
        this.mClose = (Double) in.readValue(Double.class.getClassLoader());
        this.mHigh = (Double) in.readValue(Double.class.getClassLoader());
        this.mLow = (Double) in.readValue(Double.class.getClassLoader());
        this.mOpen = (Double) in.readValue(Double.class.getClassLoader());
        this.mVolume = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Series> CREATOR = new Parcelable.Creator<Series>() {
        @Override
        public Series createFromParcel(Parcel source) {
            return new Series(source);
        }

        @Override
        public Series[] newArray(int size) {
            return new Series[size];
        }
    };
}
