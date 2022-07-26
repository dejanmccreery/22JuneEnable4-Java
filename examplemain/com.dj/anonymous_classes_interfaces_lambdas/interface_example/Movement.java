package anonymous_classes_interfaces_lambdas.interface_example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Movement {

    int X = 50;

    // You can have instance variables in abstract classes, and use a method to change them
    // with interfaces you can't
    // Methods are public and abstract by default -- i.e. they can only be called
    // We can have static class-level variables -- these are public and final by default

    // default methods in interfaces
    default void printX(){
        System.out.println(Movement.X);
    }


    void move(Player player);

}
