package Book_Test;

public class DBTest {
	public static void main(String args[])throws Exception{
		System.out.println(Conpool.getInstance().toString());
		MyCon con = null;
		for(int i=0;i<5;i++) {
			con = Conpool.getInstance().getCon();
		}
		System.out.println(Conpool.getInstance().toString());
		Conpool.getInstance().setFree(con);
		System.out.println(Conpool.getInstance().toString());
	}
}
