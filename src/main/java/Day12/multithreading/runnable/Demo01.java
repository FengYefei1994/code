package Day12.multithreading.runnable;

/**
 * 实现Runnable借口，重写run()方法实现多线程
 */
public class Demo01 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " >>> " + i);
        }
    }

    public static void main(String[] args) {
        Demo01 target = new Demo01();
        Thread thread01 = new Thread(target);
        Thread thread02 = new Thread(target);
        Thread thread03 = new Thread(target);
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
