public class Calculator {

    public static void main(String[] args) {

    }

    public double add(double num1, double num2){
        return num1 + num2;
    }

    public double subtract(double num1, double num2){
        return num1 - num2;
    }

    public double multiply(double num1, double num2){
        return num1 * num2;
    }

    public double divide(double num1, double num2){

        if (num2 == 0) {
            throw new RuntimeException("Cannot divide by 0");
        } else return num1 / num2;

    }



}
