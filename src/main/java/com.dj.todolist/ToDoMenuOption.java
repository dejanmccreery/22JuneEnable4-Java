package com.dj.todolist;

public enum ToDoMenuOption {

    // enum reflects the menu
    CREATE("1", "(Create a new To Do Item)"),
    READ("2", "(Print out the full To Do List)"),
    UPDATE("3", ("Update an item in the To Do List")),
    DELETE_BY_ID("4", "(Identify an item in the list by its ID, and delete it)"),
    DELETE_BY_NAME("5","(Identify an item in the list by its ID, and delete it)"),
    EXIT("EXIT", "(Close app)");

    private String inputCode;
    private String description;

    // if we want to have codes for the enums like C,R,U,D,DN (morgan's syntax)
    // then we'd use the getter below and alter the print menu to make it accept these codes
        // e.g. %d -> %s, ordinal() -> getter
    //let's do this with ints to make it dynamic

    private ToDoMenuOption(String inputCode, String description) {
        this.inputCode = inputCode;
        this.description = description;
    }
    public String getInputCode() { return inputCode; }

}
