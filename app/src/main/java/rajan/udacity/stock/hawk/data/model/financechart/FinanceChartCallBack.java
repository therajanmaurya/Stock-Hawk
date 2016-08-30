package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class FinanceChartCallBack implements Parcelable {

    @SerializedName("meta")
    Meta mMeta;

    @SerializedName("Date")
    Date mDate;

    @SerializedName("labels")
    Labels mLabels;

    @SerializedName("series")
    SeriesList mSeries;

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

    public Labels getLabels() {
        return mLabels;
    }

    public void setLabels(Labels labels) {
        mLabels = labels;
    }

    public SeriesList getSeries() {
        return mSeries;
    }

    public void setSeries(SeriesList series) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mMeta, flags);
        dest.writeParcelable(this.mDate, flags);
        dest.writeParcelable(this.mLabels, flags);
        dest.writeParcelable(this.mSeries, flags);
    }

    public FinanceChartCallBack() {
    }

    protected FinanceChartCallBack(Parcel in) {
        this.mMeta = in.readParcelable(Meta.class.getClassLoader());
        this.mDate = in.readParcelable(Date.class.getClassLoader());
        this.mLabels = in.readParcelable(Labels.class.getClassLoader());
        this.mSeries = in.readParcelable(SeriesList.class.getClassLoader());
    }

    public static final Parcelable.Creator<FinanceChartCallBack> CREATOR =
            new Parcelable.Creator<FinanceChartCallBack>() {
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
