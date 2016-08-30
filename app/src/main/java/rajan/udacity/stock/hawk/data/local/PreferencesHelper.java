package rajan.udacity.stock.hawk.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import rajan.udacity.stock.hawk.injection.ApplicationContext;
import rx.Observable;

@Singleton
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "stocks_pref_file";
    public static final String PREF_CHANGE_IN_PERCENT = "change_in_percent";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public Boolean getChangeInPercentFromPref() {
        return mPref.getBoolean(PREF_CHANGE_IN_PERCENT, true);
    }

    public Observable<Boolean> getChangeInPercent() {
        return Observable.just(mPref.getBoolean(PREF_CHANGE_IN_PERCENT, true));
    }

    public void setChangeInPercent(boolean changeInPercent) {
        mPref.edit().putBoolean(PREF_CHANGE_IN_PERCENT, changeInPercent).apply();
    }

    public Observable<Boolean> updateChangeInPercentInPref() {
        setChangeInPercent(!getChangeInPercentFromPref());
        return getChangeInPercent();
    }
}
