public class Factorial {

    public static void main(String[] args) {

    }

    public int factorial(int num){
        int sum = num;
        for (int i = num-1; i > 1; i--){
            sum *= i;
        }
        return sum;
    }

    public int recursiveFactorial(int num) {

        if (num <= 1) return 1;
        return num * recursiveFactorial(num-1);

        //The Call Stack and Recursive Programming

        // stack is a LIFO data structure -- last in first out
        // latest item on the stack is the first that comes off it

        // calling a method inside a method adds it to the stack

        // so with recursive programming, the method calls inside itself
            // and if the number n-1 is greater than 1 (so say we have num = 6, n-1 = 5)
            // it goes to the second line, and then the method is called again
                // and so on and so forth
            // when the number finally reaches 1, it returns 1

            // at this point the function is not called inside itself, and we start returning data

            // as 1 is the result of the latest method call, it is the first returned
            // then we return the result of 2*1 bc 2 was the n in n-1 = 1
            // and then 3 * (2*1) bc that is the result of the recursive call with num = 3
            // and so on until we hit 6.
            // this is called unravelling, as, as we can see, the whole thing unravels
                // everything is returned one by one, feeding into the next



    }

}
