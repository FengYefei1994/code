package Day12.multithreading.communication;

public class Accounting02 extends Thread {
	private int total;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			total += i;
			System.out.println(total);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("会计:" + this.getName() + "已经计算出结果了");
	}

	public int getTotal() {
		return total;
	}
}
