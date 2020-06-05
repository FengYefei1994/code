package Day12.multithreading.sync_thread;

/**
 * @author 李昊哲
 * @version 1.0
 * @date 2020/6/4 上午11:44
 */
public class class31 extends Thread {
    private static int ticket = 150;

    @Override
    public void run() {
        print();
    }
    // 同步函数
    public synchronized static void print() {
        while (ticket > 0) {
            try {
                Thread.sleep(00);
                if (ticket == 0) {
                    System.out.println("人在囧途");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "卖票" + ticket + "号票");
                ticket--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        class31 demo01 = new class31();
        demo01.setName("携程");
        demo01.setPriority(1);
        class31 demo02 = new class31();
        demo02.setName("微信");
        demo02.setPriority(10);
        class31 demo03 = new class31();
        demo03.setName("支付宝");
        demo01.start();
        demo02.start();
        demo03.start();
    }
}
