package Dynamicproxymode;


//������ӿ�
	public class User implements ProductFactory{
		public void ProductThing(String thing) {
			System.out.println("������"+ thing);
		}
	}