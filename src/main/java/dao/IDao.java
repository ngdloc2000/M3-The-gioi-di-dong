package dao;

import java.util.List;

public interface IDao<T> {
    List<T> findAll();

    void add(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}
