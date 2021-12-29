package web.model;

public class Car {

    private String model;


    private int sits;

    private String color;

    public Car(String model, int sits, String color) {
        this.model = model;
        this.sits = sits;
        this.color = color;
    }

    public int getSits() {
        return sits;
    }

    public String getColor() {
        return color;
    }


    public String getModel() {
        return model;
    }

}
