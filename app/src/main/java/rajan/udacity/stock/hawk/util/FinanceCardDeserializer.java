package rajan.udacity.stock.hawk.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartData;

/**
 * Created by Rajan Maurya on 31/08/16.
 */
public class FinanceCardDeserializer implements JsonDeserializer<FinanceChartData> {

    @Override
    public FinanceChartData deserialize(JsonElement json, Type typeOfT,
                                        JsonDeserializationContext context)
            throws JsonParseException {

        Gson gson=new Gson();

        String result = json.toString();

        if (result.startsWith("finance_charts_json_callback( ")) {
            result = result.substring(29, result.length() - 2);
        }
        Type type = new TypeToken<FinanceChartData>() {}.getType();

        return gson.fromJson(result, typeOfT);
    }
}
