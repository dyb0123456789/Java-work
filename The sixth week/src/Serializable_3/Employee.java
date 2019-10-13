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
		    //说明实现的序列化
			System.out.println("父类实现序列化");
		}else{
		    //未实现序列化
			System.out.println("父类没有实现序列化");
		}
		if(e instanceof Serializable){
		    //说明实现的序列化
			System.out.println("子类实现序列化");
		}else{
		    //未实现序列化
			System.out.println("子类没有实现序列化");
		}
	}
}
