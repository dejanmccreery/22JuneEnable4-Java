package com.dj.todolist.controller;

import com.dj.todolist.domain.entity.ToDoItem;
import com.dj.todolist.domain.repository.Repository;
import com.dj.todolist.utilities.InputUtilities;

import java.time.LocalDate;
import java.util.List;

public class ToDoController {

    private Repository<ToDoItem, Long> todoRepo;

    public ToDoController(Repository<ToDoItem, Long> todoRepo) {
        this.todoRepo = todoRepo;
    }

    //best practice would be to do smth like taking in a ToDoItem and return a response class
        // that contains a to do item
    public void create(){
        String name = InputUtilities.getString("Name of Item: ");
        String date = InputUtilities.getString("Due Date (yyyy-mm-dd): ");

        todoRepo.save(new ToDoItem(name, LocalDate.parse(date)));
        System.out.println("\nItem created and added successfully.\n\n");
    }

    public ToDoItem createForTest(){
        String name = InputUtilities.getString("Name of Item: ");
        String date = InputUtilities.getString("Due Date (yyyy-mm-dd): ");

        ToDoItem item = todoRepo.saveForTest(new ToDoItem(name, LocalDate.parse(date)));
        System.out.println("\nItem created and added successfully.\n\n");

        return item;
    }

    public void update(){

    }

    public void read(){
        System.out.println("\nItem List");
        List<ToDoItem> readList = todoRepo.read();

        for (ToDoItem item : readList) {
            System.out.println(item.repr());
        }

        System.out.print("\n\n");

    }

    public void deleteByID(){

        long id = InputUtilities.getInt("ID: ");
        boolean deleted = todoRepo.deleteByID(id);

        if (deleted) System.out.println("Successfully deleted.");
        else System.out.println("Item could not be deleted.");

    }

//    public void deleteByName(){
//        String name = InputUtilities.getString("Name of Item: ");
//        boolean deleted = todoRepo.deleteByName(name);
//
//        if (deleted) System.out.println("Successfully deleted.");
//        else System.out.println("Item could not be deleted.");
//    }
//
}
