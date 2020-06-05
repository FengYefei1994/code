package Day12.multithreading.communication;

/**
 * 线程等待/启动
 */
public class waitAndnotify extends Thread {
	private int total;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			try {
				total += i;
				System.out.println(total);
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
		System.out.println("会计:" + this.getName() + "已经计算出结果了");
		this.notify();
	}

	public synchronized int getTotal() {
		try {
			System.out.println("经理进入等待状态...");
			this.wait();
		} catch (InterruptedException e) {
		}
		return total;
	}
}
