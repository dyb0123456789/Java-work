package Book_Test;

import Data_processing.Connection;

public class MyCon {
	public static final int FREE = 100;  //�������ӿ���
	public static final int BUZY = 101;  //�������ӷ�æ
	public static final int CLOSED = 102; //��ǰ���ӹر�
	private Connection con;               //���е����ݿ�����
	private int state = FREE;            //���ݿ����ӵ�ǰ��״̬����ʼʱΪ����״̬
	public MyCon(Connection con) {
		this.con = con;
	}
	public Connection getCon() {
		return con;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
