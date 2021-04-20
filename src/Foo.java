
public class Foo {

    String str = "";

    public synchronized void first() {
        while (!str.equals("")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("first");
        str = "first";
        notify();
    }

    public synchronized void second() {
        while (!str.equals("first")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("second");
        str = "second";
        notify();
    }

    public synchronized void third() {
        while (!str.equals("second")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("third");
        str = "";
        notify();
    }
}
//Дан класс:
//
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//}
//
//Один и тот же экземпляр данного класса будет передан в 3 разных потока. Поток А - будет вызывать метод first(). Поток B - second(). Поток С - third().
//Необходимо реализовать механизм и изменить программу таким образом, что у всех потоков будут вызваны в правильном порядке.
//
//
//Пример:
//Вывод: "firstsecondthird"
//Мы не знаем, в каком порядке будут вызваны методы, но должны гарантировать порядок.