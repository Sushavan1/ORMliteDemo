package com.rtllabs.ormlitedemo.repo;

import java.util.List;

public interface DatabaseInterface {
    int create(Object item);

    int update(Object item);

    int delete(Object item);

    void deleteAllData();

    Object findById(int id);

    List<?> findByName(String name);

    List<?> findAll();
    List<?> findByNameStaringWith(String str);
}
