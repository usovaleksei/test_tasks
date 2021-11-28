package nbki;

/**
 * Class display numbers from one to hundred
 * if the number is a multiple of three then it is replaced by Fizz
 * if the number is a multiple of five then it is replaced by Buzz
 * if the number is a multiple of three and five then it is replaced by FizzBuzz
 */

public class TaskThree {

    private void fizzBuzzOutput() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        TaskThree task = new TaskThree();
        task.fizzBuzzOutput();
    }
}
