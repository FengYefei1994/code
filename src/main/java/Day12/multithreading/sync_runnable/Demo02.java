package Day12.multithreading.sync_runnable;

/**
 * 同步代码块后，将方法提出调用
 */
public class Demo02 implements Runnable {
    private int ticket = 50;

    @Override
    public void run() {
        print();
    }
    public void print() {
        while (ticket > 0) {
            synchronized (getClass()) {
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
        Demo02 target = new Demo02();
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

