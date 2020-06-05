package Day12.multithreading.thread;

/**
 * 线程守护——main中是用户线程，为主线程;
 * 守护线程需要在start前用setDaemon(true)方法设置
 * 可以用isDaemon()方法判断线程是否为守护线程
 */
public class Protect extends Thread{
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + " >>> " + count++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Protect demo01 = new Protect();
        // 守护线程
        demo01.setDaemon(true);
        demo01.setName("Jack");
        demo01.start();
        int count = 0;
        Thread.currentThread().setName("Rose");
        while (true) {
            try {
                if (count == 25){
                    System.out.println(Thread.currentThread().getName() + " >>> " + "Jump");
                    break;
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println(Thread.currentThread().getName() + " >>> " + count++);
        }
    }
}
