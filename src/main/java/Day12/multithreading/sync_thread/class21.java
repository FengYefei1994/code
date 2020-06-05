package Day12.multithreading.sync_thread;

/**
 * @author 李昊哲
 * @version 1.0
 * @date 2020/6/4 上午11:44
 */
public class class21 extends Thread {
    private static int ticket = 50;

    @Override
    public void run() {
        synchronized (class21.class) {
            while (ticket > 0) {
                try {
                    Thread.sleep(0);
                    if (ticket == 0) {
                        System.out.println("人在囧途");
                        return;
                    }
                    System.out.println(this.getName() + "卖票" + ticket + "号票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        class21 demo01 = new class21();
        demo01.setName("微信");
        class21 demo02 = new class21();
        demo02.setName("携程");
        class21 demo03 = new class21();
        demo03.setName("支付宝");
        demo02.start();
        demo01.start();
        demo03.start();
    }
}
