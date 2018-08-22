package com.peer2pay.peer2pay.helperClasses.fileManagement;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class FileManagement {
    private final static String PREFERENCE = "info";
    private Context context;

    public FileManagement(Context context) {
        this.context = context;
    }

    @Deprecated
    public void newTransaction(int cardNumberLastDigits, String timestamp, int amount, boolean isSuccess, boolean isPay){
        //TODO change transaction to a class
        String node = "{" +
                "\"cardNumberLastDigits\":\"" + String.valueOf(cardNumberLastDigits) + "\", " +
                "\"timestamp\":\"" + timestamp + "\", " +
                "\"ammount\":\"" + String.valueOf(amount) + "\", " +
                "\"isSuccess\":\"" + String.valueOf(isSuccess) + "\", " +
                "\"isPay\":\"" + String.valueOf(isPay) + "\"}";
        addSharedPreference(timestamp , node);
    }

    void setCountID(int countID){
        addSharedPreference("count", countID);
    }

    int getCountID(){
        return getSharedPreferenceInt("count");
    }

    void addSharedPreference(String name, String node){
        SharedPreferences.Editor editor = getEditor();
        editor.putString(name, node);
        editor.apply();
    }

    void addSharedPreference(String name, int node){
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(name, node);
        editor.apply();
    }

    void removeSharedPreference(String name){
        SharedPreferences.Editor editor = getEditor();
        editor.remove(name);
        editor.apply();
    }

    String getSharedPreferenceString(String name){
        return getPreference().getString(name, "");
    }

    SharedPreferences getPreference(){
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
    }

    //helper methods

    private int getSharedPreferenceInt(String name){
        return getPreference().getInt(name, 0);
    }

    private SharedPreferences.Editor getEditor(){
        return getPreference().edit();
    }
}
