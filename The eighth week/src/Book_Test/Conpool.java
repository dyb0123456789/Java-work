package Book_Test;

import java.util.ArrayList;
import java.util.List;

import Data_processing.Connection;

public class Conpool {
	/**
	 * ���ݿ����ӵ�
	 * �ó�Ϊ����
	 * �û��ɴӴ˳��л�ȡ����״̬�����ݿ�����
	 */
	private List<MyCon>freeCons = new ArrayList<MyCon>();   //������������
	private List<MyCon>buzyCons = new ArrayList<MyCon>();   //��æ��������
	private int max = 10;
	private int min = 2;
	private int current = 0;
	private static Conpool instance;  //����ʵ��
	/**
	 * ˽�еĹ��췽�����ڹ����ʵ��ʱ����鵱ǰ�����Ƿ�С����С���ӣ����С�ڣ��򴴽��µ�����ֱ�����ڻ������С����
	 */
	private Conpool() {
		while(this.min>this.current) {
			this.freeCons.add(this.createCon());
		}
	}
	/**
	 * ��ȡ��ʵ��
	 */
	public static Conpool getInstance() {
		if(instance == null)
			instance = new Conpool();
		return instance;
	}
	/**
	 *��ȡ�������ݿ����� 
	 *�ȴӿ����б����ҳ�һ������
	 *��������б���û�����ӣ�����ͼ����һ������
	 */
	public MyCon getCon(){
		MyCon myCon = this.getFreeCon();
		if(myCon !=null) {
			return myCon;
		}else {
			return this.getNewCon();
		}
	}
	/**
	 * ��ȡһ����������
	 */
	private MyCon getFreeCon() {
		if(freeCons.size()>0){
			MyCon con = freeCons.remove(0);
			con.setState(MyCon.BUZY);
			this.buzyCons.add(con);
			return con;
		}else {
			return null;
		}
	}
	/**
	 * ��ͼ��ȡһ��������
	 * �����ǰ������С������򴴽��µ����ӣ����򷵻�null
	 */
	private MyCon getNewCon() {
		if(this.current<this.max) {
			MyCon myCon=this.createCon();
			myCon.setState(MyCon.BUZY);
			this.buzyCons.add(myCon);
			return myCon;
		}else {
			return null;
		}
	}
	/**
	 * �����µ����ӣ������µ�ǰ��������
	 */
	private MyCon createCon() {
		try {
			Connection con = MySqlDAO.getConnection();
			MyCon myCon = new MyCon(con);
			this.current++;
			return myCon;
		}catch(Exception e) {}
		return null;
	}
	/**
	 * ��������Ϊ����״̬
	 * @param con
	 */
	public void setFree(MyCon con) {
		this.buzyCons.remove(con);
		con.setState(MyCon.FREE);
		this.freeCons.add(con);
	}
	/**
	 * �����ǰ�ص�����״̬
	 */
	public String toString() {
		return "��ǰ������:"+this.current+"����������:"+this.freeCons.size()+"��æ������:"+this.buzyCons.size();
	}
}
