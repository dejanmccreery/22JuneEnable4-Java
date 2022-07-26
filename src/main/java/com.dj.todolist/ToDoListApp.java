package com.dj.todolist;

import com.dj.todolist.controller.ToDoController;
import com.dj.todolist.utilities.InputUtilities;

public class ToDoListApp {

    private boolean isRunning = true;
    private ToDoController todoController;

    public ToDoListApp(ToDoController todoController) {
        this.todoController = todoController;
        // this is the D of SOLID principles
        // DEPENDENCY INVERSION
        // -- An object should not be responsible for creating its own dependencies
        // -- These should be passed in from an external source
            // - Dependency Inversion reduces coupling.
            //   Instead of being tied to a particular class, we can use any
            //      ToDoController or subclass thereof
        // -- The big upside of Dependency Inversion
        //    When the app becomes more complex, with DI it is easier to change.
    }

    public void run() {

        //reusing do-while loop
        do {

        //EXCEPTION HANDLING ================================================================
        // - exceptions will crash the programme
        // - exceptions come from the Exception class
        // - There are checked and Unchecked exceptions
            // - uncheck are classic Java ones, which do not need to be handled, but
            //   but will crash the programme if they aren't handled
            // - checked exceptions must be handled

            try{ // we are using try/catch bc entering rubbish returns null, and null breaks the switch
                 // and so the app crashes
                //menu
                printMenu();

                // get input
                // shows us it's expecting input
                String input = InputUtilities.getString("> ");
                // to make an enum work in switch input, we have to instantiate a variable
                ToDoMenuOption option = getInputOption(input);

                switch (option) {
                    // what happens when you select what function you want by menu number
                    case CREATE:
                        todoController.create();
                        break;

                    case READ:
                        todoController.read();
                        break;

                    case UPDATE:

                        break;

                    case DELETE_BY_ID:

                        break;

                    case DELETE_BY_NAME:

                        break;

                    case EXIT:
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Please enter a valid option. \n");
                }
            } catch (IllegalArgumentException e) {
                // we should always be specific with exceptions
                System.out.println("Error: " + e.getMessage());
            // w catch blocks we always go from most specific to least specific
            } catch (Exception e) {
                System.out.println("Something went wrong...");
            }

        } while (isRunning);
    }

    private ToDoMenuOption getInputOption(String input) {
//        return ToDoMenuOption.valueOf(input);
        // we could do this, but it would throw an exception if the String wasn't valid
        ToDoMenuOption[] menuOptions = ToDoMenuOption.values();
        for (int i = 0; i < menuOptions.length; i++) {
            if (menuOptions[i].getInputCode().equalsIgnoreCase(input)){
                return menuOptions[i];
            }
        }
    //     return null; -- if we don't find a valid menu option
        // rather than return null, it would be better practice to return an exception
        throw new IllegalArgumentException("Input was invalid.");
    }

    private void printMenu() {
        ToDoMenuOption[] menuOptions = ToDoMenuOption.values();
        // iterating across list
        for (int i = 0; i < menuOptions.length; i++){
            // formatted string, which is then printed -- note ordinal. gets the number in the list
                // maybe useful method in future
            String output = String.format("%s | %s", menuOptions[i].getInputCode(),
                                                    menuOptions[i].toString());
            System.out.println(output);
        }
    }


}
