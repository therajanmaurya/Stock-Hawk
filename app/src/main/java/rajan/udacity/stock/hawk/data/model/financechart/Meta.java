package rajan.udacity.stock.hawk.data.model.financechart;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class Meta implements Parcelable {

    @SerializedName("uri")
    String mUri;

    @SerializedName("ticker")
    String mTicker;

    @SerializedName("Company-Name")
    String mCompanyName;

    @SerializedName("Exchange-Name")
    String mExchangeName;

    @SerializedName("unit")
    String mUnit;

    @SerializedName("timestamp")
    String mTimestamp;

    @SerializedName("first-trade")
    Double mFirstTrade;

    @SerializedName("last-trade")
    Double mLastTrade;

    @SerializedName("currency")
    String mCurrency;

    @SerializedName("previous_close_price")
    Double mPreviousClosePrice;

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getTicker() {
        return mTicker;
    }

    public void setTicker(String ticker) {
        mTicker = ticker;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getExchangeName() {
        return mExchangeName;
    }

    public void setExchangeName(String exchangeName) {
        mExchangeName = exchangeName;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setUnit(String unit) {
        mUnit = unit;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public Double getFirstTrade() {
        return mFirstTrade;
    }

    public void setFirstTrade(Double firstTrade) {
        mFirstTrade = firstTrade;
    }

    public Double getLastTrade() {
        return mLastTrade;
    }

    public void setLastTrade(Double lastTrade) {
        mLastTrade = lastTrade;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public Double getPreviousClosePrice() {
        return mPreviousClosePrice;
    }

    public void setPreviousClosePrice(Double previousClosePrice) {
        mPreviousClosePrice = previousClosePrice;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "mUri='" + mUri + '\'' +
                ", mTicker='" + mTicker + '\'' +
                ", mCompanyName='" + mCompanyName + '\'' +
                ", mExchangeName='" + mExchangeName + '\'' +
                ", mUnit='" + mUnit + '\'' +
                ", mTimestamp='" + mTimestamp + '\'' +
                ", mFirstTrade=" + mFirstTrade +
                ", mLastTrade=" + mLastTrade +
                ", mCurrency='" + mCurrency + '\'' +
                ", mPreviousClosePrice=" + mPreviousClosePrice +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mUri);
        dest.writeString(this.mTicker);
        dest.writeString(this.mCompanyName);
        dest.writeString(this.mExchangeName);
        dest.writeString(this.mUnit);
        dest.writeString(this.mTimestamp);
        dest.writeValue(this.mFirstTrade);
        dest.writeValue(this.mLastTrade);
        dest.writeString(this.mCurrency);
        dest.writeValue(this.mPreviousClosePrice);
    }

    public Meta() {
    }

    protected Meta(Parcel in) {
        this.mUri = in.readString();
        this.mTicker = in.readString();
        this.mCompanyName = in.readString();
        this.mExchangeName = in.readString();
        this.mUnit = in.readString();
        this.mTimestamp = in.readString();
        this.mFirstTrade = (Double) in.readValue(Double.class.getClassLoader());
        this.mLastTrade = (Double) in.readValue(Double.class.getClassLoader());
        this.mCurrency = in.readString();
        this.mPreviousClosePrice = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel source) {
            return new Meta(source);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };
}
