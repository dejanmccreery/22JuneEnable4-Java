package anonymous_classes_interfaces_lambdas.mapping_example;

import java.util.*;

public class Mapping {

    public static void main(String[] args) {

        //list string is best practice for arrays
        List<String> stringArray = new ArrayList<>(Arrays.asList("hello", "hi", "guten tag"));

        Set<String> stringSet = new HashSet<>();

        System.out.println(stringArray);
        stringSet.add("hallo der"); //adds to index 0 in sets
                                    // array.add adds to index -1
        // the ascii or binary code has to be unique every time -- so S and s are different


        // those above require one dataype
        // maps require two
        Map<Integer, String> superheroesMap = new HashMap<>();
        superheroesMap.put(1, "Batman");
        superheroesMap.get(1);


    }

}
