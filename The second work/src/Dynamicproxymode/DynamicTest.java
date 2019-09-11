package Dynamicproxymode;

import java.lang.reflect.Proxy;

public class DynamicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		ProductFactory productfactory = (ProductFactory)Proxy.newProxyInstance(
				ProductFactory.class.getClassLoader(),
				new Class[] {ProductFactory.class},new MyProxy(user));
		productfactory.ProductThing("ÒÂ·þ");
	}
}
