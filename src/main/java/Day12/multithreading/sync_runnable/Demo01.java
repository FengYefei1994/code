package Day12.multithreading.sync_runnable;

/**
 * 三种方式实现同步锁——同步代码块
 */
public class Demo01 implements Runnable {
    private int ticket = 50;

    @Override
    public void run() {
        while (ticket > 0) {
            //synchronized (getClass()) {
            //synchronized (Demo01.class) {
            synchronized (this) {

                if (ticket == 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " 卖第 " + ticket + " 号票");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ticket--;
            }
        }
    }

    public static void main(String[] args) {
        Demo01 target = new Demo01();
        Thread thread01 = new Thread(target);
        Thread thread02 = new Thread(target);
        Thread thread03 = new Thread(target);
        thread01.setName("携程");
        thread02.setName("微信");
        thread03.setName("支付宝");
        thread01.start();
        thread02.start();
        thread03.start();
    }
}

