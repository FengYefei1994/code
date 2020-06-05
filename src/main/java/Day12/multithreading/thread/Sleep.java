package Day12.multithreading.thread;

/**
 * 线程休眠
 */
public class Sleep extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " >>> " + i);
            try {
                if (i % 2 == 0 && "Thread-0".equals(Thread.currentThread().getName())) {
                    Thread.sleep(200);
                }
                if (i % 2 == 0 && "Thread-1".equals(Thread.currentThread().getName())) {
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Sleep demo01 = new Sleep();
        Sleep demo02 = new Sleep();
        demo01.start();
        demo02.start();
    }
}
