package com.example.mindbrowser.model.roomdatabase;

import androidx.room.TypeConverter;

import com.example.mindbrowser.model.ContactModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    @TypeConverter
    public static ArrayList<ContactModel> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayLisr(ArrayList<ContactModel> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


}
