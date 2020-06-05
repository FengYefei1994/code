package Day12.multithreading.communication;

public class Accounting02Test {
	public static void main(String[] args) {
		Thread.currentThread().setName("经理");
		Accounting02 accounting01 = new Accounting02();
		accounting01.setName("小丽");
		System.out.println(Thread.currentThread().getName() + "问：你能把1 + 2 + 3 + ... + 100的结果给我吗");
		System.out.println(accounting01.getName() + "答：OK");
		accounting01.start();
		try {
			// 抢
			accounting01.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int total = accounting01.getTotal();
		System.out.println("结果是>>>" + total);
	}
}
