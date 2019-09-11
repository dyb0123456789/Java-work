package Dynamicproxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyProxy implements InvocationHandler{
	private Object proxied;
	public MyProxy(Object proxied) {
		super();
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
	throws Throwable{
		method.invoke(this.proxied, args);
		System.out.println("运行时间：" + System.currentTimeMillis());
		return null;
	}
}
