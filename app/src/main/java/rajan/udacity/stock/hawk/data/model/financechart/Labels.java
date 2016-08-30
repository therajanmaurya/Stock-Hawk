package rajan.udacity.stock.hawk.data.model.financechart;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class Labels implements Parcelable {

    List<Double> labels = new ArrayList<>();

    public List<Double> getLabels() {
        return labels;
    }

    public void setLabels(List<Double> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "labels=" + labels +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.labels);
    }

    public Labels() {
    }

    protected Labels(Parcel in) {
        this.labels = new ArrayList<Double>();
        in.readList(this.labels, Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Labels> CREATOR = new Parcelable.Creator<Labels>() {
        @Override
        public Labels createFromParcel(Parcel source) {
            return new Labels(source);
        }

        @Override
        public Labels[] newArray(int size) {
            return new Labels[size];
        }
    };
}
