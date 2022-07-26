package anonymous_classes_interfaces_lambdas.anonclass_example;

public abstract class Vehicle {

    int id;
    String type;
    String manufacturer;
    String model;
    int modelYear;
    String colour;

    public Vehicle (String manufacturer, String model, String colour, int modelYear){
        super();
        this.manufacturer = manufacturer;
        this.model = model;
        this.modelYear = modelYear;
        this.colour = colour;

    }

    // watch lecture on builders with interfaces

    public abstract void move(int degrees, int distance);
    public abstract void noise(float decibels);
    public abstract void light(String light);



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}

