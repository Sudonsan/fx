package com.forex.forex;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayUtil {
    public static ArrayList<Object> convert(JSONArray jArr)
    {
        ArrayList<Object> list = new ArrayList<Object>();
        try {
            for (int i=0, l=jArr.length(); i<l; i++){
                list.add(jArr.get(i));
            }
        } catch (JSONException e) {}

        return list;
    }

    public static JSONArray convert(JsonArray list)
    {
        return new JSONArray(list);
    }

}
