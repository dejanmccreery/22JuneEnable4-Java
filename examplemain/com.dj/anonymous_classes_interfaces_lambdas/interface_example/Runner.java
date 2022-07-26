package anonymous_classes_interfaces_lambdas.interface_example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Runner {

    public static void main(String[] args) {
        Player p1 = new Player("Fred");

        Movement running = new RunningBehaviour();
        Movement walking = new WalkingBehaviour();

        // 4 built-in interfaces for functional Programming in Java
        // 1) Consumer <T>
        // 2) Supplier <T>
        // 3) Predicate <T>
        // 4) Function <T, R>

        // T - the type for the method's implementation
        // R - the return type

        // CONSUMER
        // a consumer accepts a single input and returns nothing
        List<String> names = List.of("Bob", "Jens", "Hans");
        Consumer<String> printStringLength = (value) ->
                System.out.println("Length of " + value + " is " + value.length());

        //using the consumer
        printStringLength.accept("Hello");
        // forEach accepts a consumer of the type of the list
        names.forEach(printStringLength);


        // SUPPLIER
        // returns a value of the specified type
        Supplier<Movement> runBehaviourSupplier = () -> {
            return (player) -> System.out.println(player.getName() + " is moving.");
        };
      //  p1.move();

    }

}
