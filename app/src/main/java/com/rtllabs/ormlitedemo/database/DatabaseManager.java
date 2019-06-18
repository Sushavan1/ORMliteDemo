package com.rtllabs.ormlitedemo.database;

import android.content.Context;
import android.util.Log;

public class DatabaseManager {
    private static final String TAG = DatabaseManager.class.getSimpleName();
    static private DatabaseManager instance;
    private DataBaseHelper helper;

    private DatabaseManager(Context context) {
        Log.i(TAG,"call DatabaseManager");
        helper=new DataBaseHelper(context);
    }

    static public void init(Context context)
    {
        if (instance==null)
        {
            instance=new DatabaseManager(context);
        }
    }

    static public DatabaseManager getDatabaseManager() {
        return instance;
    }

    public DataBaseHelper getDataBaseHelper() {
        return helper;
    }
}
