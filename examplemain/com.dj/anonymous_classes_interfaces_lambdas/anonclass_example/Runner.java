package anonymous_classes_interfaces_lambdas.anonclass_example;

import anonymous_classes_interfaces_lambdas.anonclass_example.Vehicle;

public class Runner {

    //Anonymous classes are implementations of an abstract or interface
        // that has already been declared and used in the source code of a method

    Vehicle vehicle1 = new Vehicle("Mazda", "RX-7",
            "Red", 2021) {

        // this implementation of vehicle is an anonymous class. It is used only once to create the
        // mazda

        @Override
        public void move(int degrees, int distance) {

        }

        @Override
        public void noise(float decibels) {

        }

        @Override
        public void light(String light) {

        }
    };

}
