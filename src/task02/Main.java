package task02;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(45);
       // Runnable fizzRun = () -> System.out.println("fizz");
       // Runnable buzzRun = () -> System.out.println("buzz");
       // Runnable fizzBuzzRun = () -> System.out.println("fizzbuzz");
       // Runnable numRun = () -> System.out.println(fizzBuzz.getX());

        Thread thread1 = new Thread(() -> fizzBuzz.fizz());
        Thread thread2 = new Thread(() -> fizzBuzz.buzz());
        Thread thread3 = new Thread(() -> fizzBuzz.fizzbuzz());
        Thread thread4 = new Thread(() -> fizzBuzz.number());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
}
