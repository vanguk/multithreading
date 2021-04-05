public class main {
    public static void main(String[] args) {
        Foo myFoo = new Foo();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myFoo.first();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myFoo.second();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myFoo.third();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
