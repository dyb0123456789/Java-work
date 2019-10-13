package MatrixWorkThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixTest {
	public final static int M=200;//���峣��������A������
	public final static int K=200;//���峣��������A������������B������
	public final static int N=200;//���峣��������B������//36560
	final static int NUM_THREADS=5;//���峣�����߳�����
	private static int [][]A; //����A
	private static int [][]B; //����B
	private static int [][]C; //����C
	//--------------------------
	//�����๹�췽��
	public MatrixTest() {
		A=new int [M][K];  
		B=new int [K][N];
		C=new int [M][N];  //A��B��C��ʼ��
		fillRandom(A);//��0-99���������ʼ������A
		fillRandom(B);//��0-99���������ʼ������B
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				C[i][j]=0;//��C����ȫ����
	}
	
	//------------------
	//��ʼ������������0-99���������ʼ������A��B
	private void fillRandom(int [][] A) {
		Random rand = new Random(25);
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[i].length;j++) {
				A[i][j]=rand.nextInt(100);
			}
		}
	}
	
	//-----------------
	//main����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MatrixTest();//�½�һ�����������
		//ʹ���̳߳صķ�����������
		Thread []poolThreads = new Thread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++)
			poolThreads[i] = new Thread(new WorkThread(i,A,B,C));
		//�����̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		long time1 = System.currentTimeMillis();//��¼��ʼʱ��
		for(int i=0;i<NUM_THREADS;i++)
			pool.execute(poolThreads[i]);//���ĸ������̷߳����̳߳���
		pool.shutdown();//���̳߳���ֹǰ����ִ����ǰ�ύ������
		while(true) {
			if(pool.isTerminated()) {
				break;
			}
		}//��һ����ѭ���ж��̳߳��Ƿ�ִ�����
		long time2 = System.currentTimeMillis();//��¼����ʱ��
		System.out.println("����["+M+","+K+"]��["+K+","+N+"]�׾���˷����̳߳ؼ�����ʱ��"+(time2-time1)+"����");
	}

}
