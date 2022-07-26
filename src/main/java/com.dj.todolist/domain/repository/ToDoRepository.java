package com.dj.todolist.domain.repository;

import com.dj.todolist.domain.entity.ToDoItem;

import java.util.ArrayList;
import java.util.List;

public class ToDoRepository {

    private List<ToDoItem> listOfItems;
    private long idCounter;

    public ToDoRepository() {
        this.listOfItems = new ArrayList<>();
        idCounter = 1;
    }

    public boolean save(ToDoItem item) {

        for (int i = 0; i < listOfItems.size(); i++){
            ToDoItem current = listOfItems.get(i);

            // item.getID() == current.getID()
            // each item has a unique id so
            if (item.getName().equals(current.getName())) {
                throw new RuntimeException("A To Do Item with this name already exists.");
            }
        }

        item.setID(idCounter++);
        listOfItems.add(item);
        return true;
    }

    public List<ToDoItem> read(){
        return listOfItems;
    }

    public boolean update(ToDoItem item) {
        return true;

        // thinking a search and then a setter

    }

    public boolean deleteByID(long id){
        boolean deleted = false; //default

        //using full for loop bc we are modifying the array by deleting values
        for (int i = 0; i < listOfItems.size(); i++) {
            ToDoItem current = listOfItems.get(i);

            if (current.getID() == id){
                deleted = listOfItems.remove(current);
                break;
            }
        }
        return deleted;
    }

    public boolean deleteByName(String name){
        boolean deleted = false;

        for (int i = 0; i < listOfItems.size(); i++){
            ToDoItem current = listOfItems.get(i);

            if (current.getName().equals(name)){
                deleted = listOfItems.remove(current);
            }
        }

        return deleted;
    }

}
