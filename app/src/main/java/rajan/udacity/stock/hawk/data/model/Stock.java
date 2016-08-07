package rajan.udacity.stock.hawk.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;
import android.support.annotation.NonNull;

@AutoValue
public abstract class Stock implements Comparable<Stock>, Parcelable {

    public abstract Profile profile();

    public static Stock create(Profile profile) {
        return new AutoValue_Ribot(profile);
    }

    public static TypeAdapter<Stock> typeAdapter(Gson gson) {
        return new AutoValue_Ribot.GsonTypeAdapter(gson);
    }

    @Override
    public int compareTo(@NonNull Stock another) {
        return profile().name().first().compareToIgnoreCase(another.profile().name().first());
    }
}

