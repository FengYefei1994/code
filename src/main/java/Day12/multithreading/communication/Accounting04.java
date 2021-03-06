package Day12.multithreading.communication;

public class Accounting04 {
	private String name;
	private float amount;

	public Accounting04(String name, float amount) {
		this.name = name;
		this.amount = amount;
	}

	public synchronized void deposit(float amt) {
		float tmp = amount;
		tmp += amt;

		try {
			Thread.currentThread().join(100);
			// Thread.sleep(100);// 模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			// ignore
		}

		amount = tmp;
	}

	public synchronized void withdraw(float amt) {
		float tmp = amount;
		tmp -= amt;

		try {
			Thread.currentThread().join(100);
			// Thread.sleep(100);// 模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			// ignore
		}

		amount = tmp;
	}

	public float getBalance() {
		return amount;
	}
}
