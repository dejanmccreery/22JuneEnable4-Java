package anonymous_classes_interfaces_lambdas.lambda_example;

import anonymous_classes_interfaces_lambdas.interface_example.Movement;
import anonymous_classes_interfaces_lambdas.interface_example.Player;

public class Runner {

    //LAMBDA EXPRESSIONS
    // - The method implementation of an interface
    // - Specifies a parameter list followed by a body of code to execute

    // Syntax: (param1, param2, param3) -> Method Implementation

    // Syntax form 2: (param1, param2, param3) -> { Method Implementation }
    // -- in the first form, we do not need to specify a return value if we want to return smth
    // -- in the second form we do

    // An anonymous implementation can be implemented by using a Lambda
    Player p1 = new Player("Fred");

    // The lambda expression MUST match the method header of the interface it is implementing
    // -- we do not need to specify the DType of the params or the returned  object
    // -- these are inferred from the interface

    Movement walkingBehaviour = (player) -> System.out.println(player.getName() + " is walking.");
    Movement runningBehaviour = (player) -> {
        System.out.println(player.getName() + " is running.");
    }; // we close the lambda with a semicolon whatever the format

    // IMPERATIVE vs DECLARATIVE PROGRAMMING
    // - Imperative: We instruct the computer line by line on each instruction we want it to execute
    //               so as to solve any given problem.
    // - Declarative: We describe what we want from the programme. Existing implementations will then
    //               be performed in the background without us necessarily needing to know
    //               what implementation is used.

    // lambdas bridge imperative to declarative. single-line simplicity of imperative
    // but is declarative

}
