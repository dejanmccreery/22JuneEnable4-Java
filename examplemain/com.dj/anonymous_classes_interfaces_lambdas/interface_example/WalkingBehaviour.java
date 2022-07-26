package anonymous_classes_interfaces_lambdas.interface_example;

public class WalkingBehaviour implements Movement {

    public void run(Player player){
        System.out.println(player + " is walking.");
    }

    @Override
    public void printX() {
        Movement.super.printX();
    }

    @Override
    public void move(Player player) {

    }

}
