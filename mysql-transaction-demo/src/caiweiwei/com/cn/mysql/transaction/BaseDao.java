package caiweiwei.com.cn.mysql.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	final static String driver = "com.mysql.jdbc.Driver";  
    final static String dburl = "jdbc:mysql://192.168.43.2:3306/wallet";  
    final static String name = "chao";  
    final static String password = "123456";
      
    Connection con = null;  
    PreparedStatement ps = null;  
    ResultSet rs = null;  
      
    public  void openCon() throws  Exception {  
          
        Class.forName(driver);  
        con = DriverManager.getConnection(dburl,name,password);  
        System.out.println(con);  
          
    }  
    public void closeCon() throws Exception{  
        if(ps!=null){  
            ps.close();  
        }  
        if(rs!=null){  
            rs.close();  
        }  
        if(con!=null){  
            con.close();  
          
        }  
    }  
}
