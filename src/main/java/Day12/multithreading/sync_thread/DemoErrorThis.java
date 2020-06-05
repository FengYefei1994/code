package Day12.multithreading.sync_thread;

/**
 * @author 李昊哲
 * @version 1.0
 * @date 2020/6/4 上午11:44
 */
public class DemoErrorThis extends Thread {
    private static int ticket = 50;

    @Override
    public void run() {
        while (ticket > 0) {
            // 同步代码块 这是个bug
            synchronized (this) {//此时this有三个对象，锁不唯一
                try {
                    Thread.sleep(200);
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
        DemoErrorThis demo01 = new DemoErrorThis();
        demo01.setName("携程");
        DemoErrorThis demo02 = new DemoErrorThis();
        demo02.setName("微信");
        DemoErrorThis demo03 = new DemoErrorThis();
        demo03.setName("支付宝");
        demo01.start();
        demo02.start();
        demo03.start();
    }
}
