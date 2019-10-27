package Book_Test;

import java.util.ArrayList;
import java.util.List;

import Data_processing.Connection;

public class Conpool {
	/**
	 * 数据库连接地
	 * 该池为单例
	 * 用户可从此池中获取含有状态的数据库连接
	 */
	private List<MyCon>freeCons = new ArrayList<MyCon>();   //空闲连接链表
	private List<MyCon>buzyCons = new ArrayList<MyCon>();   //繁忙连接链表
	private int max = 10;
	private int min = 2;
	private int current = 0;
	private static Conpool instance;  //单例实例
	/**
	 * 私有的构造方法，在构造池实例时，检查当前连接是否小于最小链接，如果小于，则创建新的连接直到大于或等于最小连接
	 */
	private Conpool() {
		while(this.min>this.current) {
			this.freeCons.add(this.createCon());
		}
	}
	/**
	 * 获取池实例
	 */
	public static Conpool getInstance() {
		if(instance == null)
			instance = new Conpool();
		return instance;
	}
	/**
	 *获取空闲数据库连接 
	 *先从空闲列表中找出一个连接
	 *如果空闲列表中没用连接，则试图创建一个连接
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
	 * 获取一个空闲连接
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
	 * 试图获取一个新连接
	 * 如果当前连接数小于最大，则创建新的连接，否则返回null
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
	 * 创建新的连接，并更新当前连接总数
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
	 * 将连接设为空闲状态
	 * @param con
	 */
	public void setFree(MyCon con) {
		this.buzyCons.remove(con);
		con.setState(MyCon.FREE);
		this.freeCons.add(con);
	}
	/**
	 * 输出当前池的连接状态
	 */
	public String toString() {
		return "当前连接数:"+this.current+"空闲连接数:"+this.freeCons.size()+"繁忙连接数:"+this.buzyCons.size();
	}
}
