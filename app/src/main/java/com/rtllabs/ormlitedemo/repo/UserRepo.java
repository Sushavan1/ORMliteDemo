package com.rtllabs.ormlitedemo.repo;

import com.rtllabs.ormlitedemo.database.DataBaseHelper;
import com.rtllabs.ormlitedemo.database.DatabaseManager;
import com.rtllabs.ormlitedemo.models.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserRepo implements DatabaseInterface {
    DataBaseHelper dataBaseHelper;

    public UserRepo() {
        this.dataBaseHelper = DatabaseManager.getDatabaseManager().getDataBaseHelper();
    }

    @Override
    public int create(Object item) {
        int index=-1;
        UserDao userDao = (UserDao) item;
        try {
            index=dataBaseHelper.getUsersDao().create(userDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int update(Object item) {
        int index=-1;
        UserDao userDao = (UserDao) item;
        try {
            index=dataBaseHelper.getUsersDao().update(userDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int delete(Object item) {
        int index=-1;
        UserDao userDao = (UserDao) item;
        try {
            index=dataBaseHelper.getUsersDao().delete(userDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public void deleteAllData() {
        try {
            dataBaseHelper.getUsersDao().delete((List<UserDao>) findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object findById(int id) {
        UserDao userDao =null;
        try {
            userDao =dataBaseHelper.getUsersDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDao;
    }

    @Override
    public List<?> findByName(String name) {
        List<UserDao> userDaos =null;
        try {
            userDaos =dataBaseHelper.getUsersDao().queryBuilder().where().eq("name",name).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDaos;
    }

    @Override
    public List<?> findAll() {
        List<UserDao> userDaos =null;
        try {
            userDaos =dataBaseHelper.getUsersDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDaos;
    }

    @Override
    public List<?> findByNameStaringWith(String str) {
        List<UserDao> userDaos =null;
        try {
            userDaos =dataBaseHelper.getUsersDao().queryBuilder().where().like("name",str).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDaos;
    }
}
