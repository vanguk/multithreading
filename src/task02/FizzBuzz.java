package task02;

public class FizzBuzz {
    private int x;
    int num = 1;
    private boolean isComplete = false;

    public FizzBuzz(int x) {
        this.x = x;
    }

    public synchronized void fizz() {
        while (num <= x) {
            if (num % 3 == 0 && !isComplete && num % 5 != 0) {
                System.out.println("fizz");
                isComplete = true;
                num++;
                notifyAll();
            } else {
                try {
                    isComplete = false;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (num <= x) {
            if (num % 5 == 0 && !isComplete && num % 3 != 0) {
                System.out.println("buzz");
                isComplete = true;
                num++;
                notifyAll();
            } else {
                try {
                    isComplete = false;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (num <= x) {
            if (num % 3 == 0 && num % 5 == 0 && !isComplete) {
                System.out.println("fizzbuzz");
                isComplete = true;
                num++;
                notifyAll();
            } else {
                try {
                    isComplete = false;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (num <= x) {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.println(num);
                isComplete = true;
                num++;
                notifyAll();
            } else {
                try {
                    isComplete = false;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
