package caiweiwei.com.cn.mysql.transaction;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class DoTransaction {
	/** 
     * @param args 
     * @throws SQLException  
     * @throws Exception  
     */  
    public static void main(String[] args)  {  
        BaseDao tj = new BaseDao();  
      
        try {  
              
            tj.openCon();  
              
            //注意与在数据库中操作有点不同，数据库为set autocommit = 0;  
            tj.con.setAutoCommit(false);  
            //利用占位符，减少字符串拼接的麻烦  
            String sql1 = "insert into user (id,password,money) values (?,?,?);";  
          
            //插入一条存入200块钱的数据  
            tj.ps = tj.con.prepareStatement(sql1);  
            tj.ps.setInt(1, 1003);  
            tj.ps.setString(2, "dddd");  
            tj.ps.setInt(3, 100);  
          
            //修改添加删除信息返回的是受影响行数  
            int row = tj.ps.executeUpdate();  
            //在同时插入一条取出300的数据记录  
            tj.ps = tj.con.prepareStatement(sql1);  
            tj.ps.setInt(1, 1003);  
            tj.ps.setString(2, "dddd");  
            //tj.ps.setInt(3, 300);   
            int row2 = tj.ps.executeUpdate();  
              
            //提交事务  
            tj.con.commit();  
        } catch (Exception e) {  
            try {  
                //回滚  
                tj.con.rollback();  
            } catch (SQLException e1) {  
                  
                e1.printStackTrace();  
            }  
            e.printStackTrace();  
        }  
          
          
        //然后来查询下表  
        String sql2 = "select * from user;";  
          
          
          
        try {  
            tj.ps = tj.con.prepareStatement(sql2);  
            tj.rs = tj.ps.executeQuery();//查询结果返回的是表  
        } catch (SQLException e1) {  
      
            e1.printStackTrace();  
        }  
          
          
        try {  
            while (tj.rs.next()) {  
                //控制台输出下查询到的信息  
                System.out.println(tj.rs.getInt("id")+"\t"+tj.rs.getString("password")+"\t"+  
                tj.rs.getInt("money"));  
            }  
        } catch (SQLException e) {  
              
            e.printStackTrace();  
        }
          
        try {  
            tj.closeCon();//关闭数据连接  
        } catch (Exception e) {  
              
            e.printStackTrace();  
        }  
  
    }  
}
