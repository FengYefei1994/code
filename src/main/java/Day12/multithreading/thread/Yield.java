package Day12.multithreading.thread;

/**
 * 线程让步，将CPU资源让出给其他线程使用
 */
public class Yield extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " >>> " + i);
            if (i == 10 && "Thread-0".equals(Thread.currentThread().getName())) {
                Thread.yield();
            }
            if (i == 20 && "Thread-1".equals(Thread.currentThread().getName())) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Yield demo01 = new Yield();
        Yield demo02 = new Yield();
        demo01.start();
        demo02.start();
    }
}
