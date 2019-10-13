package Serializable_3;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String address;
	public Person(String Myname,String Myaddress) {
		this.name = Myname;
		this.address = Myaddress;
	}
}
