package Day12.multithreading.thread;

/**
 * 抢线程，把指定的线程加到当前线程优先运行
 */
public class Join extends Thread {
    int sum = 0;
    @Override
    public void run() {
        System.out.println(this.getName() + "正在计算，请稍等...");
        for (int i = 0; i < 50; i++) {
            sum += i;
        }
        System.out.println(this.getName() + "已经算出结果了");
    }
    public int getSum(){
        return sum;
    }

    public static void main(String[] args) {
        Join demo01 = new Join();
        demo01.setName("小丽");
        Thread.currentThread().setName("经理");
        String name = Thread.currentThread().getName();
        System.out.println(name + "说：" + demo01.getName() + "帮我算一下 0 到50 的和");
        demo01.start();
        try {
            // 把指定的线程加入到当前线程
            demo01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = demo01.getSum();
        System.out.println("结果是 >>> " + sum);
    }
}
