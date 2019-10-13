package MatrixWorkThread;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(25);
		//int i;
		//i = rand.nextInt(100);
		for(int i =0;i<10;i++)
		{
			System.out.println(rand.nextInt(10));
		}
	}
}
