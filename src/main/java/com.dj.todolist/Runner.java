package com.dj.todolist;

import com.dj.todolist.controller.ToDoController;
import com.dj.todolist.domain.entity.ToDoItem;
import com.dj.todolist.domain.repository.Repository;
import com.dj.todolist.domain.repository.ToDoRepository;

public class Runner {

    public static void main(String[] args) {
        ToDoController todoController = new ToDoController((Repository<ToDoItem, Long>) new ToDoRepository());
        ToDoListApp tdlApp = new ToDoListApp(todoController);
        tdlApp.run();
    }
}
