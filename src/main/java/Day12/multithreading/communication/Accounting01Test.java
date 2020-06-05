package Day12.multithreading.communication;

public class Accounting01Test {
	public static void main(String[] args) {
		Thread.currentThread().setName("经理");
		Accounting01 accounting01 = new Accounting01();
		accounting01.setName("小丽");
		System.out.println(Thread.currentThread().getName() + "问：你能把1 + 2 + 3 + ... + 100的结果给我吗");
		System.out.println(accounting01.getName() + "答：OK");
		accounting01.start();
		int total = accounting01.getTotal();
		System.out.println("结果是>>>" + total);
	}
}
