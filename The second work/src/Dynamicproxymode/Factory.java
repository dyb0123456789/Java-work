package Dynamicproxymode;


//����ӿ�
	public class Factory implements ProductFactory{
		private User user;
		public Factory(User user) {
			super();
			this.user = user;
		}
		@Override
		public void ProductThing(String thing) {
			this.user.ProductThing(thing);
			System.out.println("����ʱ�䣺 "+System.currentTimeMillis());
		}
	}
