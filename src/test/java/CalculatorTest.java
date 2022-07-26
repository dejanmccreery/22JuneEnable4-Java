import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    Calculator calculator = new Calculator();
    Factorial factor = new Factorial();

//    @Test
//  we can also mark it as a parameterised test
    @ParameterizedTest
    @CsvSource({
        "10,10,20",
        "343.4,0,343.4",
        "432433,423423,855856"
    }) //csv source inputs csv strings in a list. each string is a test case
    // can also do @CsvFSource to get data from a csv file
    // @Method source too but we shall cover later
    public void addTest(double num1, double num2, double expected) {
        double actual = calculator.add(num1, num2);
        //We use an assertion to check if the results were as expected
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void subtractTest(double num1, double num2, double expected) {
        double actual = calculator.subtract(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest(double num1, double num2, double expected) {
        double actual = calculator.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void divideTest(double num1, double num2, double expected) {
        double actual = calculator.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void factorialTest(int num1, int expected){
        double actual = factor.factorial(num1);

        Assertions.assertEquals(expected, actual);
    }
}