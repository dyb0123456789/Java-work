package Data_processing;

import java.sql.Connection;
import java.sql.SQLException;


public class PoolTest {

    /**
     * �������ݿ����ӳ�
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        JdbcUtil util = new JdbcUtil();
        try {
    		long time1 = System.currentTimeMillis();
            Connection conn = util.getConnection();
            /*if(conn != null){
                System.out.println("�ҵõ���һ������");
            }*/
            util.CloseConnection(conn, null, null);
            long time2 = System.currentTimeMillis();
    		System.out.println("���Ӵ�������10000����ʱ��"+(time2-time1)+"����");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}