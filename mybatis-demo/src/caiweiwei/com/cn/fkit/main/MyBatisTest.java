package caiweiwei.com.cn.fkit.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import caiweiwei.com.cn.fkit.domain.User;

public class MyBatisTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User("admin", "男", 26);
		session.insert("caiweiwei.com.cn.fkit.mapper.UserMapper.save", user);
		session.commit();
		session.close();
	}

}
