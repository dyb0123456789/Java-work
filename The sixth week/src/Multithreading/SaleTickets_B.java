package Multithreading;

public class SaleTickets_B implements Runnable{
	private String threadName;
	private int tickets;
	public SaleTickets_B(String threadName,int Tickets)
	{
		this.threadName = threadName;
		this.tickets = Tickets;
	}
	public void run() {
		for(int i = 1;i<=tickets;i++) {
			System.out.println(threadName+"�̴߳���������"+i+"Ʊ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------������ʼ ------");
		Thread sale = new Thread(new SaleTickets_B("B",10));
		sale.start();
		System.out.println("------���������------");
	}
}
