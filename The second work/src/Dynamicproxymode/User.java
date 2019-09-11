package Dynamicproxymode;


//被代理接口
	public class User implements ProductFactory{
		public void ProductThing(String thing) {
			System.out.println("想生产"+ thing);
		}
	}