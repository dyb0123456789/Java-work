package Serializable_3;

import java.io.Serializable;

public class Employee extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int number;
	public Employee(String Myname,String Myaddress,int Mynumber) {
		super(Myname,Myaddress);
		this.number = Mynumber;
	}
	public static void main(String [] args) {
		Person p = new Person("Mary","Wuhan");
		Employee e = new Employee("Mary","Wuhan",001);
		if(p instanceof Serializable){
		    //˵��ʵ�ֵ����л�
			System.out.println("����ʵ�����л�");
		}else{
		    //δʵ�����л�
			System.out.println("����û��ʵ�����л�");
		}
		if(e instanceof Serializable){
		    //˵��ʵ�ֵ����л�
			System.out.println("����ʵ�����л�");
		}else{
		    //δʵ�����л�
			System.out.println("����û��ʵ�����л�");
		}
	}
}
