package Dynamicproxymode;


//代理接口
	public class Factory implements ProductFactory{
		private User user;
		public Factory(User user) {
			super();
			this.user = user;
		}
		@Override
		public void ProductThing(String thing) {
			this.user.ProductThing(thing);
			System.out.println("运行时间： "+System.currentTimeMillis());
		}
	}
