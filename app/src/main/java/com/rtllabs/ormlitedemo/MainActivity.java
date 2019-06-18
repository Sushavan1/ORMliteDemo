package com.rtllabs.ormlitedemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rtllabs.ormlitedemo.database.DatabaseManager;
import com.rtllabs.ormlitedemo.models.UserDao;
import com.rtllabs.ormlitedemo.repo.UserRepo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private UserRepo userRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }



    private void init() {
        DatabaseManager.init(MainActivity.this);
    userRepo=new UserRepo();
        saveData();
    }

    private void saveData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // userRepo.deleteAllData();
                UserDao userDao1 = new UserDao("Sushavan", "sushavan1@gmail.com");
                UserDao userDao2 = new UserDao("Sushavan2", "sushavan2@gmail.com");
                userRepo.create(userDao1);
                userRepo.create(userDao2);
               // userDao2.setEmail("Raja");
               // userRepo.update(userDao2);
                retrieveData();

            }
        }, 500);
    }

    private void retrieveData() {
        List<UserDao> userDaoList = null;
       // userDaoList = (List<UserDao>) userRepo.findAll();
       // userDaoList = (List<UserDao>) userRepo.findByName("Sushavan");
        userDaoList = (List<UserDao>) userRepo.findByNameStaringWith("Su");
        for (UserDao userDao : userDaoList) {
            System.out.println(userDao.toString());
        }
    }
}
