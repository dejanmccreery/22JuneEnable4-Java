package com.dj.todolist.domain.repository;
import com.dj.todolist.domain.entity.ToDoItem;

import java.util.List;

// T represents the type of the data
// U represents the type of the data's id field
public interface Repository<T, V> {

    // an interface that d
    //interface methods are public abstract by default

    boolean save(T obj);
    ToDoItem saveForTest(T obj);
    List<T> read();
    void update(T obj);
    boolean deleteByID(V id);
}
