package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class FinanceChartData implements Parcelable {

    @SerializedName("finance_charts_json_callback")
    FinanceChartCallBack mFinanceChartsJsonCallback;

    public FinanceChartCallBack getFinanceChartsJsonCallback() {
        return mFinanceChartsJsonCallback;
    }

    public void setFinanceChartsJsonCallback(FinanceChartCallBack financeChartsJsonCallback) {
        mFinanceChartsJsonCallback = financeChartsJsonCallback;
    }

    @Override
    public String toString() {
        return "FinanceChartData{" +
                "mFinanceChartsJsonCallback=" + mFinanceChartsJsonCallback +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mFinanceChartsJsonCallback, flags);
    }

    public FinanceChartData() {
    }

    protected FinanceChartData(Parcel in) {
        this.mFinanceChartsJsonCallback =
                in.readParcelable(FinanceChartCallBack.class.getClassLoader());
    }

    public static final Parcelable.Creator<FinanceChartData> CREATOR =
            new Parcelable.Creator<FinanceChartData>() {
        @Override
        public FinanceChartData createFromParcel(Parcel source) {
            return new FinanceChartData(source);
        }

        @Override
        public FinanceChartData[] newArray(int size) {
            return new FinanceChartData[size];
        }
    };
}
