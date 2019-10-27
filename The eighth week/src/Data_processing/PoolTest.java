package Data_processing;

import java.sql.Connection;
import java.sql.SQLException;


public class PoolTest {

    /**
     * 测试数据库连接池
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        JdbcUtil util = new JdbcUtil();
        try {
    		long time1 = System.currentTimeMillis();
            Connection conn = util.getConnection();
            /*if(conn != null){
                System.out.println("我得到了一个连接");
            }*/
            util.CloseConnection(conn, null, null);
            long time2 = System.currentTimeMillis();
    		System.out.println("连接处理数据10000次用时："+(time2-time1)+"毫秒");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}