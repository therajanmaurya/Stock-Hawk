package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class FinanceChartCallBack implements Parcelable {

    @SerializedName("meta")
    Meta mMeta;

    @SerializedName("Date")
    Date mDate;

    @SerializedName("labels")
    List<Double> mLabels = new ArrayList<>();

    @SerializedName("series")
    List<Series> mSeries = new ArrayList<>();

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public List<Double> getLabels() {
        return mLabels;
    }

    public void setLabels(List<Double> labels) {
        mLabels = labels;
    }

    public List<Series> getSeries() {
        return mSeries;
    }

    public void setSeries(List<Series> series) {
        mSeries = series;
    }

    @Override
    public String toString() {
        return "FinanceChartCallBack{" +
                "mMeta=" + mMeta +
                ", mDate=" + mDate +
                ", mLabels=" + mLabels +
                ", mSeries=" + mSeries +
                '}';
    }


    public FinanceChartCallBack() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mMeta, flags);
        dest.writeParcelable(this.mDate, flags);
        dest.writeList(this.mLabels);
        dest.writeTypedList(this.mSeries);
    }

    protected FinanceChartCallBack(Parcel in) {
        this.mMeta = in.readParcelable(Meta.class.getClassLoader());
        this.mDate = in.readParcelable(Date.class.getClassLoader());
        this.mLabels = new ArrayList<Double>();
        in.readList(this.mLabels, Double.class.getClassLoader());
        this.mSeries = in.createTypedArrayList(Series.CREATOR);
    }

    public static final Creator<FinanceChartCallBack> CREATOR =
            new Creator<FinanceChartCallBack>() {
        @Override
        public FinanceChartCallBack createFromParcel(Parcel source) {
            return new FinanceChartCallBack(source);
        }

        @Override
        public FinanceChartCallBack[] newArray(int size) {
            return new FinanceChartCallBack[size];
        }
    };
}
