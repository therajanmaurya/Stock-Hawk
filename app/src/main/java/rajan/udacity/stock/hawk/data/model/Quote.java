package rajan.udacity.stock.hawk.data.model;

import com.google.gson.annotations.SerializedName;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import android.os.Parcel;
import android.os.Parcelable;

import rajan.udacity.stock.hawk.data.local.StockBaseModel;
import rajan.udacity.stock.hawk.data.local.StockDatabase;

/**
 * Created by Rajan Maurya on 07/08/16.
 */
@Table(database = StockDatabase.class)
@ModelContainer
public class Quote extends StockBaseModel implements Parcelable {

    @SerializedName("symbol")
    @PrimaryKey
    @Column
    String msymbol;

    @SerializedName("Ask")
    Double mAsk;
    @SerializedName("AverageDailyVolume")
    Double mAverageDailyVolume;

    @SerializedName("Bid")
    @Column
    Double mBid;

    @SerializedName("BookValue")
    Double mBookValue;

    @SerializedName("Change_PercentChange")
    String mChangePercentChange;

    @SerializedName("Change")
    @Column
    String mChange;

    @SerializedName("Currency")
    String mCurrency;

    @SerializedName("LastTradeDate")
    String mLastTradeDate;

    @SerializedName("EarningsShare")
    Double mEarningsShare;

    @SerializedName("EPSEstimateCurrentYear")
    String mEPSEstimateCurrentYear;

    @SerializedName("EPSEstimateNextYear")
    String mEPSEstimateNextYear;

    @SerializedName("EPSEstimateNextQuarter")
    String mEPSEstimateNextQuarter;

    @SerializedName("DaysLow")
    Double mDaysLow;

    @SerializedName("DaysHigh")
    Double DaysHigh;

    @SerializedName("YearLow")
    Double mYearLow;

    @SerializedName("YearHigh")
    Double mYearHigh;

    @SerializedName("MarketCapitalization")
    String mMarketCapitalization;

    @SerializedName("EBITDA")
    String mEBITDA;

    @SerializedName("ChangeFromYearLow")
    Double mChangeFromYearLow;

    @SerializedName("PercentChangeFromYearLow")
    String mPercentChangeFromYearLow;

    @SerializedName("ChangeFromYearHigh")
    Double mChangeFromYearHigh;

    @SerializedName("PercebtChangeFromYearHigh")
    String mPercebtChangeFromYearHigh;

    @SerializedName("LastTradeWithTime")
    String mLastTradeWithTime;

    @SerializedName("LastTradePriceOnly")
    Double mLastTradePriceOnly;

    @SerializedName("DaysRange")
    String mDaysRange;

    @SerializedName("FiftydayMovingAverage")
    Double mFiftydayMovingAverage;

    @SerializedName("TwoHundreddayMovingAverage")
    Double mTwoHundreddayMovingAverage;

    @SerializedName("ChangeFromTwoHundreddayMovingAverage")
    Double mChangeFromTwoHundreddayMovingAverage;

    @SerializedName("PercentChangeFromTwoHundreddayMovingAverage")
    String mPercentChangeFromTwoHundreddayMovingAverage;

    @SerializedName("ChangeFromFiftydayMovingAverage")
    Double mChangeFromFiftydayMovingAverage;

    @SerializedName("PercentChangeFromFiftydayMovingAverage")
    String mPercentChangeFromFiftydayMovingAverage;

    @SerializedName("Name")
    String mName;

    @SerializedName("Open")
    Double mOpen;

    @SerializedName("PreviousClose")
    Double mPreviousClose;

    @SerializedName("ChangeinPercent")
    @Column
    String mChangeinPercent;

    @SerializedName("PriceSales")
    Double mPriceSales;

    @SerializedName("PriceBook")
    Double mPriceBook;

    @SerializedName("PEGRatio")
    Double mPEGRatio;

    @SerializedName("PriceEPSEstimateCurrentYear")
    Double mPriceEPSEstimateCurrentYear;

    @SerializedName("PriceEPSEstimateNextYear")
    Double mPriceEPSEstimateNextYear;

    @SerializedName("Symbol")
    String mSymbol;

    @SerializedName("ShortRatio")
    Double mShortRatio;

    @SerializedName("LastTradeTime")
    String mLastTradeTime;

    @SerializedName("OneyrTargetPrice")
    Double mOneyrTargetPrice;

    @SerializedName("Volume")
    Double mVolume;

    @SerializedName("YearRange")
    String mYearRange;

    @SerializedName("StockExchange")
    String mStockExchange;

    @SerializedName("PercentChange")
    String mPercentChange;

    public Quote() {
    }

    protected Quote(Parcel in) {
        this.msymbol = in.readString();
        this.mAsk = (Double) in.readValue(Double.class.getClassLoader());
        this.mAverageDailyVolume = (Double) in.readValue(Double.class.getClassLoader());
        this.mBid = (Double) in.readValue(Double.class.getClassLoader());
        this.mBookValue = (Double) in.readValue(Double.class.getClassLoader());
        this.mChangePercentChange = in.readString();
        this.mChange = (String) in.readValue(String.class.getClassLoader());
        this.mCurrency = in.readString();
        this.mLastTradeDate = in.readString();
        this.mEarningsShare = (Double) in.readValue(Double.class.getClassLoader());
        this.mEPSEstimateCurrentYear = (String) in.readValue(String.class.getClassLoader());
        this.mEPSEstimateNextYear = (String) in.readValue(String.class.getClassLoader());
        this.mEPSEstimateNextQuarter = (String) in.readValue(String.class.getClassLoader());
        this.mDaysLow = (Double) in.readValue(Double.class.getClassLoader());
        this.DaysHigh = (Double) in.readValue(Double.class.getClassLoader());
        this.mYearLow = (Double) in.readValue(Double.class.getClassLoader());
        this.mYearHigh = (Double) in.readValue(Double.class.getClassLoader());
        this.mMarketCapitalization = in.readString();
        this.mEBITDA = in.readString();
        this.mChangeFromYearLow = (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChangeFromYearLow = in.readString();
        this.mChangeFromYearHigh = (Double) in.readValue(Double.class.getClassLoader());
        this.mPercebtChangeFromYearHigh = in.readString();
        this.mLastTradeWithTime = in.readString();
        this.mLastTradePriceOnly = (Double) in.readValue(Double.class.getClassLoader());
        this.mDaysRange = in.readString();
        this.mFiftydayMovingAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.mTwoHundreddayMovingAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.mChangeFromTwoHundreddayMovingAverage =
                (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChangeFromTwoHundreddayMovingAverage = in.readString();
        this.mChangeFromFiftydayMovingAverage =
                (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChangeFromFiftydayMovingAverage = in.readString();
        this.mName = in.readString();
        this.mOpen = (Double) in.readValue(Double.class.getClassLoader());
        this.mPreviousClose = (Double) in.readValue(Double.class.getClassLoader());
        this.mChangeinPercent = in.readString();
        this.mPriceSales = (Double) in.readValue(Double.class.getClassLoader());
        this.mPriceBook = (Double) in.readValue(Double.class.getClassLoader());
        this.mPEGRatio = (Double) in.readValue(Double.class.getClassLoader());
        this.mPriceEPSEstimateCurrentYear = (Double) in.readValue(Double.class.getClassLoader());
        this.mPriceEPSEstimateNextYear = (Double) in.readValue(Double.class.getClassLoader());
        this.mSymbol = in.readString();
        this.mShortRatio = (Double) in.readValue(Double.class.getClassLoader());
        this.mLastTradeTime = in.readString();
        this.mOneyrTargetPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.mVolume = (Double) in.readValue(Double.class.getClassLoader());
        this.mYearRange = in.readString();
        this.mStockExchange = in.readString();
        this.mPercentChange = in.readString();
    }

    public String getMsymbol() {
        return msymbol;
    }

    public void setMsymbol(String msymbol) {
        this.msymbol = msymbol;
    }

    public Double getAsk() {
        return mAsk;
    }

    public void setAsk(Double ask) {
        mAsk = ask;
    }

    public Double getAverageDailyVolume() {
        return mAverageDailyVolume;
    }

    public void setAverageDailyVolume(Double averageDailyVolume) {
        mAverageDailyVolume = averageDailyVolume;
    }

    public Double getBid() {
        return mBid;
    }

    public void setBid(Double bid) {
        mBid = bid;
    }

    public Double getBookValue() {
        return mBookValue;
    }

    public void setBookValue(Double bookValue) {
        mBookValue = bookValue;
    }

    public String getChangePercentChange() {
        return mChangePercentChange;
    }

    public void setChangePercentChange(String changePercentChange) {
        mChangePercentChange = changePercentChange;
    }

    public String getChange() {
        return mChange;
    }

    public void setChange(String change) {
        mChange = change;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getLastTradeDate() {
        return mLastTradeDate;
    }

    public void setLastTradeDate(String lastTradeDate) {
        mLastTradeDate = lastTradeDate;
    }

    public Double getEarningsShare() {
        return mEarningsShare;
    }

    public void setEarningsShare(Double earningsShare) {
        mEarningsShare = earningsShare;
    }

    public String getEPSEstimateCurrentYear() {
        return mEPSEstimateCurrentYear;
    }

    public void setEPSEstimateCurrentYear(String EPSEstimateCurrentYear) {
        mEPSEstimateCurrentYear = EPSEstimateCurrentYear;
    }

    public String getEPSEstimateNextYear() {
        return mEPSEstimateNextYear;
    }

    public void setEPSEstimateNextYear(String EPSEstimateNextYear) {
        mEPSEstimateNextYear = EPSEstimateNextYear;
    }

    public String getEPSEstimateNextQuarter() {
        return mEPSEstimateNextQuarter;
    }

    public void setEPSEstimateNextQuarter(String EPSEstimateNextQuarter) {
        mEPSEstimateNextQuarter = EPSEstimateNextQuarter;
    }

    public Double getDaysLow() {
        return mDaysLow;
    }

    public void setDaysLow(Double daysLow) {
        mDaysLow = daysLow;
    }

    public Double getDaysHigh() {
        return DaysHigh;
    }

    public void setDaysHigh(Double daysHigh) {
        DaysHigh = daysHigh;
    }

    public Double getYearLow() {
        return mYearLow;
    }

    public void setYearLow(Double yearLow) {
        mYearLow = yearLow;
    }

    public Double getYearHigh() {
        return mYearHigh;
    }

    public void setYearHigh(Double yearHigh) {
        mYearHigh = yearHigh;
    }

    public String getMarketCapitalization() {
        return mMarketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        mMarketCapitalization = marketCapitalization;
    }

    public String getEBITDA() {
        return mEBITDA;
    }

    public void setEBITDA(String EBITDA) {
        mEBITDA = EBITDA;
    }

    public Double getChangeFromYearLow() {
        return mChangeFromYearLow;
    }

    public void setChangeFromYearLow(Double changeFromYearLow) {
        mChangeFromYearLow = changeFromYearLow;
    }

    public String getPercentChangeFromYearLow() {
        return mPercentChangeFromYearLow;
    }

    public void setPercentChangeFromYearLow(String percentChangeFromYearLow) {
        mPercentChangeFromYearLow = percentChangeFromYearLow;
    }

    public Double getChangeFromYearHigh() {
        return mChangeFromYearHigh;
    }

    public void setChangeFromYearHigh(Double changeFromYearHigh) {
        mChangeFromYearHigh = changeFromYearHigh;
    }

    public String getPercebtChangeFromYearHigh() {
        return mPercebtChangeFromYearHigh;
    }

    public void setPercebtChangeFromYearHigh(String percebtChangeFromYearHigh) {
        mPercebtChangeFromYearHigh = percebtChangeFromYearHigh;
    }

    public String getLastTradeWithTime() {
        return mLastTradeWithTime;
    }

    public void setLastTradeWithTime(String lastTradeWithTime) {
        mLastTradeWithTime = lastTradeWithTime;
    }

    public Double getLastTradePriceOnly() {
        return mLastTradePriceOnly;
    }

    public void setLastTradePriceOnly(Double lastTradePriceOnly) {
        mLastTradePriceOnly = lastTradePriceOnly;
    }

    public String getDaysRange() {
        return mDaysRange;
    }

    public void setDaysRange(String daysRange) {
        mDaysRange = daysRange;
    }

    public Double getFiftydayMovingAverage() {
        return mFiftydayMovingAverage;
    }

    public void setFiftydayMovingAverage(Double fiftydayMovingAverage) {
        mFiftydayMovingAverage = fiftydayMovingAverage;
    }

    public Double getTwoHundreddayMovingAverage() {
        return mTwoHundreddayMovingAverage;
    }

    public void setTwoHundreddayMovingAverage(Double twoHundreddayMovingAverage) {
        mTwoHundreddayMovingAverage = twoHundreddayMovingAverage;
    }

    public Double getChangeFromTwoHundreddayMovingAverage() {
        return mChangeFromTwoHundreddayMovingAverage;
    }

    public void setChangeFromTwoHundreddayMovingAverage(
            Double changeFromTwoHundreddayMovingAverage) {
        mChangeFromTwoHundreddayMovingAverage = changeFromTwoHundreddayMovingAverage;
    }

    public String getPercentChangeFromTwoHundreddayMovingAverage() {
        return mPercentChangeFromTwoHundreddayMovingAverage;
    }

    public void setPercentChangeFromTwoHundreddayMovingAverage(
            String percentChangeFromTwoHundreddayMovingAverage) {
        mPercentChangeFromTwoHundreddayMovingAverage = percentChangeFromTwoHundreddayMovingAverage;
    }

    public Double getChangeFromFiftydayMovingAverage() {
        return mChangeFromFiftydayMovingAverage;
    }

    public void setChangeFromFiftydayMovingAverage(Double changeFromFiftydayMovingAverage) {
        mChangeFromFiftydayMovingAverage = changeFromFiftydayMovingAverage;
    }

    public String getPercentChangeFromFiftydayMovingAverage() {
        return mPercentChangeFromFiftydayMovingAverage;
    }

    public void setPercentChangeFromFiftydayMovingAverage(
            String percentChangeFromFiftydayMovingAverage) {
        mPercentChangeFromFiftydayMovingAverage = percentChangeFromFiftydayMovingAverage;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Double getOpen() {
        return mOpen;
    }

    public void setOpen(Double open) {
        mOpen = open;
    }

    public Double getPreviousClose() {
        return mPreviousClose;
    }

    public void setPreviousClose(Double previousClose) {
        mPreviousClose = previousClose;
    }

    public String getChangeinPercent() {
        return mChangeinPercent;
    }

    public void setChangeinPercent(String changeinPercent) {
        mChangeinPercent = changeinPercent;
    }

    public Double getPriceSales() {
        return mPriceSales;
    }

    public void setPriceSales(Double priceSales) {
        mPriceSales = priceSales;
    }

    public Double getPriceBook() {
        return mPriceBook;
    }

    public void setPriceBook(Double priceBook) {
        mPriceBook = priceBook;
    }

    public Double getPEGRatio() {
        return mPEGRatio;
    }

    public void setPEGRatio(Double PEGRatio) {
        mPEGRatio = PEGRatio;
    }

    public Double getPriceEPSEstimateCurrentYear() {
        return mPriceEPSEstimateCurrentYear;
    }

    public void setPriceEPSEstimateCurrentYear(Double priceEPSEstimateCurrentYear) {
        mPriceEPSEstimateCurrentYear = priceEPSEstimateCurrentYear;
    }

    public Double getPriceEPSEstimateNextYear() {
        return mPriceEPSEstimateNextYear;
    }

    public void setPriceEPSEstimateNextYear(Double priceEPSEstimateNextYear) {
        mPriceEPSEstimateNextYear = priceEPSEstimateNextYear;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

    public Double getShortRatio() {
        return mShortRatio;
    }

    public void setShortRatio(Double shortRatio) {
        mShortRatio = shortRatio;
    }

    public String getLastTradeTime() {
        return mLastTradeTime;
    }

    public void setLastTradeTime(String lastTradeTime) {
        mLastTradeTime = lastTradeTime;
    }

    public Double getOneyrTargetPrice() {
        return mOneyrTargetPrice;
    }

    public void setOneyrTargetPrice(Double oneyrTargetPrice) {
        mOneyrTargetPrice = oneyrTargetPrice;
    }

    public Double getVolume() {
        return mVolume;
    }

    public void setVolume(Double volume) {
        mVolume = volume;
    }

    public String getYearRange() {
        return mYearRange;
    }

    public void setYearRange(String yearRange) {
        mYearRange = yearRange;
    }

    public String getStockExchange() {
        return mStockExchange;
    }

    public void setStockExchange(String stockExchange) {
        mStockExchange = stockExchange;
    }

    public String getPercentChange() {
        return mPercentChange;
    }

    public void setPercentChange(String percentChange) {
        mPercentChange = percentChange;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "msymbol='" + msymbol + '\'' +
                ", mAsk=" + mAsk +
                ", mAverageDailyVolume=" + mAverageDailyVolume +
                ", mBid=" + mBid +
                ", mBookValue=" + mBookValue +
                ", mChangePercentChange='" + mChangePercentChange + '\'' +
                ", mChange=" + mChange +
                ", mCurrency='" + mCurrency + '\'' +
                ", mLastTradeDate='" + mLastTradeDate + '\'' +
                ", mEarningsShare=" + mEarningsShare +
                ", mEPSEstimateCurrentYear=" + mEPSEstimateCurrentYear +
                ", mEPSEstimateNextYear=" + mEPSEstimateNextYear +
                ", mEPSEstimateNextQuarter=" + mEPSEstimateNextQuarter +
                ", mDaysLow=" + mDaysLow +
                ", DaysHigh=" + DaysHigh +
                ", mYearLow=" + mYearLow +
                ", mYearHigh=" + mYearHigh +
                ", mMarketCapitalization='" + mMarketCapitalization + '\'' +
                ", mEBITDA='" + mEBITDA + '\'' +
                ", mChangeFromYearLow=" + mChangeFromYearLow +
                ", mPercentChangeFromYearLow='" + mPercentChangeFromYearLow + '\'' +
                ", mChangeFromYearHigh=" + mChangeFromYearHigh +
                ", mPercebtChangeFromYearHigh='" + mPercebtChangeFromYearHigh + '\'' +
                ", mLastTradeWithTime='" + mLastTradeWithTime + '\'' +
                ", mLastTradePriceOnly=" + mLastTradePriceOnly +
                ", mDaysRange='" + mDaysRange + '\'' +
                ", mFiftydayMovingAverage=" + mFiftydayMovingAverage +
                ", mTwoHundreddayMovingAverage=" + mTwoHundreddayMovingAverage +
                ", mChangeFromTwoHundreddayMovingAverage=" + mChangeFromTwoHundreddayMovingAverage +
                ", mPercentChangeFromTwoHundreddayMovingAverage='"
                + mPercentChangeFromTwoHundreddayMovingAverage + '\'' +
                ", mChangeFromFiftydayMovingAverage=" + mChangeFromFiftydayMovingAverage +
                ", mPercentChangeFromFiftydayMovingAverage='" +
                mPercentChangeFromFiftydayMovingAverage + '\'' +
                ", mName='" + mName + '\'' +
                ", mOpen=" + mOpen +
                ", mPreviousClose=" + mPreviousClose +
                ", mChangeinPercent='" + mChangeinPercent + '\'' +
                ", mPriceSales=" + mPriceSales +
                ", mPriceBook=" + mPriceBook +
                ", mPEGRatio=" + mPEGRatio +
                ", mPriceEPSEstimateCurrentYear=" + mPriceEPSEstimateCurrentYear +
                ", mPriceEPSEstimateNextYear=" + mPriceEPSEstimateNextYear +
                ", mSymbol='" + mSymbol + '\'' +
                ", mShortRatio=" + mShortRatio +
                ", mLastTradeTime='" + mLastTradeTime + '\'' +
                ", mOneyrTargetPrice=" + mOneyrTargetPrice +
                ", mVolume=" + mVolume +
                ", mYearRange='" + mYearRange + '\'' +
                ", mStockExchange='" + mStockExchange + '\'' +
                ", mPercentChange='" + mPercentChange + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.msymbol);
        dest.writeValue(this.mAsk);
        dest.writeValue(this.mAverageDailyVolume);
        dest.writeValue(this.mBid);
        dest.writeValue(this.mBookValue);
        dest.writeString(this.mChangePercentChange);
        dest.writeValue(this.mChange);
        dest.writeString(this.mCurrency);
        dest.writeString(this.mLastTradeDate);
        dest.writeValue(this.mEarningsShare);
        dest.writeValue(this.mEPSEstimateCurrentYear);
        dest.writeValue(this.mEPSEstimateNextYear);
        dest.writeValue(this.mEPSEstimateNextQuarter);
        dest.writeValue(this.mDaysLow);
        dest.writeValue(this.DaysHigh);
        dest.writeValue(this.mYearLow);
        dest.writeValue(this.mYearHigh);
        dest.writeString(this.mMarketCapitalization);
        dest.writeString(this.mEBITDA);
        dest.writeValue(this.mChangeFromYearLow);
        dest.writeString(this.mPercentChangeFromYearLow);
        dest.writeValue(this.mChangeFromYearHigh);
        dest.writeString(this.mPercebtChangeFromYearHigh);
        dest.writeString(this.mLastTradeWithTime);
        dest.writeValue(this.mLastTradePriceOnly);
        dest.writeString(this.mDaysRange);
        dest.writeValue(this.mFiftydayMovingAverage);
        dest.writeValue(this.mTwoHundreddayMovingAverage);
        dest.writeValue(this.mChangeFromTwoHundreddayMovingAverage);
        dest.writeString(this.mPercentChangeFromTwoHundreddayMovingAverage);
        dest.writeValue(this.mChangeFromFiftydayMovingAverage);
        dest.writeString(this.mPercentChangeFromFiftydayMovingAverage);
        dest.writeString(this.mName);
        dest.writeValue(this.mOpen);
        dest.writeValue(this.mPreviousClose);
        dest.writeString(this.mChangeinPercent);
        dest.writeValue(this.mPriceSales);
        dest.writeValue(this.mPriceBook);
        dest.writeValue(this.mPEGRatio);
        dest.writeValue(this.mPriceEPSEstimateCurrentYear);
        dest.writeValue(this.mPriceEPSEstimateNextYear);
        dest.writeString(this.mSymbol);
        dest.writeValue(this.mShortRatio);
        dest.writeString(this.mLastTradeTime);
        dest.writeValue(this.mOneyrTargetPrice);
        dest.writeValue(this.mVolume);
        dest.writeString(this.mYearRange);
        dest.writeString(this.mStockExchange);
        dest.writeString(this.mPercentChange);
    }

    public static final Creator<Quote> CREATOR = new Creator<Quote>() {
        @Override
        public Quote createFromParcel(Parcel source) {
            return new Quote(source);
        }

        @Override
        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };
}
