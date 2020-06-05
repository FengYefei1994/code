package Day12.multithreading.sync_thread;

/**
 * @author 李昊哲
 * @version 1.0
 * @date 2020/6/4 上午11:44
 */
public class class2 extends Thread {
    private static int ticket = 200;

    @Override
    public void run() {
        while (ticket > 0) {
            // 同步代码块
            synchronized (class2.class) {
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
        class2 demo01 = new class2();
        demo01.setName("携程");
        class2 demo02 = new class2();
        demo02.setName("微信");
        class2 demo03 = new class2();
        demo03.setName("支付宝");
        demo01.start();
        demo02.start();
        demo03.start();
    }
}
