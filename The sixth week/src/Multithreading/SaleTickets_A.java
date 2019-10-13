package Multithreading;

public class SaleTickets_A extends Thread{
	private String threadName;
	private int tickets;
	public SaleTickets_A(String threadName,int Tickets)
	{
		this.threadName = threadName;
		this.tickets = Tickets;
	}
	public void run() {
		for(int i = 1;i<=tickets;i++) {
			System.out.println(threadName+"线程窗口卖出第"+i+"票");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------主程序开始 ------");
		SaleTickets_A sale = new SaleTickets_A("A",10);
		sale.start();
		System.out.println("------主程序结束------");
	}

}
