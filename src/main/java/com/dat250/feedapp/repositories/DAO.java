package com.dat250.feedapp.repositories;

import java.util.List;

public interface DAO<T> {

    List<T> read();

    T read(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
