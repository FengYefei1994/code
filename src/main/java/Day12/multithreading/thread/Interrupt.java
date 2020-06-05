package Day12.multithreading.thread;

/**
 * 线程中断
 * 线程休眠
 */
public class Interrupt extends Thread {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                if (count == 5) {
                    // 线程中断
                    Thread.currentThread().interrupt();
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println(Thread.currentThread().getName() + " >>> " + count++);
        }
    }

    public static void main(String[] args) {
        Interrupt demo01 = new Interrupt();
        demo01.start();
    }
}
