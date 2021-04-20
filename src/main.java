import java.util.concurrent.*;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo myFoo = new Foo();
        ExecutorService executorService = Executors.newCachedThreadPool();


        Runnable first = new Runnable() {
            @Override
            public void run() {
                myFoo.first();
            }
        };
        Runnable second = new Runnable() {
            @Override
            public void run() {
                myFoo.second();
            }
        };
        Runnable third = new Runnable() {
            @Override
            public void run() {
                myFoo.third();
            }
        };
        executorService.execute(second);
        executorService.execute(first);
        executorService.execute(third);
        executorService.execute(first);
        executorService.execute(third);
        executorService.execute(second);

        executorService.shutdown();

    }
}
