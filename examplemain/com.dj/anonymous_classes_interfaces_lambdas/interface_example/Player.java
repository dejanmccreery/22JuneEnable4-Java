package anonymous_classes_interfaces_lambdas.interface_example;

public class Player {

    private String name;


    public Player(String name) {
        this.name = name;
    }

    public void move(Movement type){
        type.move(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
