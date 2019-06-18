package com.rtllabs.ormlitedemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.rtllabs.ormlitedemo.models.UserDao;

import java.sql.SQLException;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DataBaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "UserDao.db";
    private static final int DATABASE_VERSION = 1;
//Datebase Access Object
    private Dao<UserDao,Integer> usersDao;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(TAG,"Table Created");
            TableUtils.createTable(connectionSource, UserDao.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserDao.class,true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<UserDao,Integer> getUsersDao(){
        if(usersDao==null) {
            try {
                usersDao=getDao(UserDao.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersDao;
    }
}
