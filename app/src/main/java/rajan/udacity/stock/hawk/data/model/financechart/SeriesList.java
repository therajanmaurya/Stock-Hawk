package rajan.udacity.stock.hawk.data.model.financechart;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class SeriesList implements Parcelable {

    List<Series> mSeries = new ArrayList<>();

    public List<Series> getSeries() {
        return mSeries;
    }

    public void setSeries(List<Series> series) {
        mSeries = series;
    }

    @Override
    public String toString() {
        return "SeriesList{" +
                "mSeries=" + mSeries +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.mSeries);
    }

    public SeriesList() {
    }

    protected SeriesList(Parcel in) {
        this.mSeries = in.createTypedArrayList(Series.CREATOR);
    }

    public static final Parcelable.Creator<SeriesList> CREATOR =
            new Parcelable.Creator<SeriesList>() {
        @Override
        public SeriesList createFromParcel(Parcel source) {
            return new SeriesList(source);
        }

        @Override
        public SeriesList[] newArray(int size) {
            return new SeriesList[size];
        }
    };
}
