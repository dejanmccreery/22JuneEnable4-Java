package com.dj.todolist.domain.entity;

import java.time.LocalDate;

public class ToDoItem {


    // we place this in model bc we are modelling a to do item
    // this is best practice for anything we are modelling e.g. a Duck, Dog, Employee, to do item, to
    // do list

    private long id;
    private String name;
    private LocalDate dueDate;

    public ToDoItem(String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }
    public ToDoItem(long id, String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (id != toDoItem.id) return false;
        if (name != null ? !name.equals(toDoItem.name) : toDoItem.name != null) return false;
        return dueDate != null ? dueDate.equals(toDoItem.dueDate) : toDoItem.dueDate == null;
    }

    public String repr() {
        return String.format("[%d] %s", this.id, this.name);
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
