package Day12.multithreading.thread;

/**
 * 获取线程名称
 * 线程重命名
 * 获取/设置线程优先级，值越大，优先级越高
 */
public class Simple extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // currentThread 当前线程
            // getName 获取线程名字
            System.out.println(Thread.currentThread().getName() + " >>> " + i);
        }
    }

    public static void main(String[] args) {
        Simple demo01 = new Simple();
        demo01.setName("线程一");
        // 获取线程当前优先级别
        System.out.println(demo01.getName() + " >>> " +demo01.getPriority());
        // 设置优先级
        demo01.setPriority(MAX_PRIORITY);
        Simple demo02 = new Simple();
        demo02.setName("线程二");
        Simple demo03 = new Simple();
        demo03.setName("线程三");
        demo01.start();
        demo02.start();
        demo03.start();
    }
}
