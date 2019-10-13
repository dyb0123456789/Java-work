package MatrixWorkThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixTest {
	public final static int M=200;//定义常量：矩阵A的行数
	public final static int K=200;//定义常量：矩阵A的列数，矩阵B的行数
	public final static int N=200;//定义常量：矩阵B的列数//36560
	final static int NUM_THREADS=5;//定义常量：线程数量
	private static int [][]A; //矩阵A
	private static int [][]B; //矩阵B
	private static int [][]C; //矩阵C
	//--------------------------
	//驱动类构造方法
	public MatrixTest() {
		A=new int [M][K];  
		B=new int [K][N];
		C=new int [M][N];  //A、B、C初始化
		fillRandom(A);//用0-99的随机数初始化矩阵A
		fillRandom(B);//用0-99的随机数初始化矩阵B
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				C[i][j]=0;//将C矩阵全置零
	}
	
	//------------------
	//初始化方法：产生0-99的随机数初始化矩阵A、B
	private void fillRandom(int [][] A) {
		Random rand = new Random(25);
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[i].length;j++) {
				A[i][j]=rand.nextInt(100);
			}
		}
	}
	
	//-----------------
	//main函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MatrixTest();//新建一个驱动类对象
		//使用线程池的方法进行运算
		Thread []poolThreads = new Thread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++)
			poolThreads[i] = new Thread(new WorkThread(i,A,B,C));
		//建立线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		long time1 = System.currentTimeMillis();//记录起始时间
		for(int i=0;i<NUM_THREADS;i++)
			pool.execute(poolThreads[i]);//将四个工作线程放入线程池中
		pool.shutdown();//在线程池终止前允许执行以前提交的任务
		while(true) {
			if(pool.isTerminated()) {
				break;
			}
		}//用一个死循环判断线程池是否执行完成
		long time2 = System.currentTimeMillis();//记录结束时间
		System.out.println("计算["+M+","+K+"]与["+K+","+N+"]阶矩阵乘法，线程池计算用时："+(time2-time1)+"毫秒");
	}

}
