package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        List<String> names = List.of("Bertie", "Johnnie", "Jimmie");

        // to turn a collection into a stream we can call its .stream() method
        names.stream()
             .forEach(name -> System.out.println(name)); //we use lambdas bc it looks nicer

        // .forEach when called on a non-infinite stream will terminate the stream once it has
        // called the consumer on each element in the stream


        // Common Terminal Operations
        // - count()
        // - min(), max()
        // - findAny(), findFirst()
        // - forEach()
        // - reduce() - used to reduce a stream of elements to a single value
        // - collect() - used to collect the result of all intermediary operations in the stream

        long namesLength = names.stream()
                                .count();

        // compareTo with string applies min, and returns the earliest in the alphabet
        names.stream().min((str1, str2) -> str1.compareTo(str2));

        Optional<String> minimumName = names.stream()
                                            .min((str1, str2) -> str1.compareTo(str2));
        // an optional represents a value either being present or there being no value at all
        // - a typesafe wrapper for null
        // we end up not needing to check if things are null
        minimumName.ifPresent((name) -> System.out.println(name));
        // - this prints out smth if its present

        //If you want to get a value out of an optional
        // - get() throws an exception if there is no value
        // - orElseThrow() allows you to specify an exception to be thrown if no value exists
        // - orElse() allows you to specify a default value to return

        String minName = minimumName.orElse("Name wasn't found.");
        minimumName.orElseThrow(() -> new RuntimeException("Name not found."));
        // lambda takes no input bc it is a Supplier interface

        // Common non-terminal / intermediary operations
        // - map() - mapping function
            // map accepts Function<T,R> where T is the input type, R the return type
        // - filter() - filter function
            // filter takes a Predicate<T>
        List<Integer> lengthOfEachName = names.stream()
                                              .map(name -> name.length())
                                              .collect(Collectors.toList());

        lengthOfEachName.forEach(length -> System.out.println("Length: " + length));
        // streams retain their original order unless they're sorted in-stream

        List<Integer> numbers = List.of(1,2,3,4,5,6);
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println); // this is a method reference
                // it automatically passes each number to the println method
                // this works here bc the println in question prints an object
                // and the forEach consumer requires type integer, or its super type
                // which is object


    }

}
