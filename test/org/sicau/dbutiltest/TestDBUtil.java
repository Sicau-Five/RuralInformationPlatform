package org.sicau.dbutiltest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;
import org.sicau.dao.Impl.jdbcBuild;
import org.sicau.util.DBConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestDBUtil extends jdbcBuild{
	
	@Test
	public void m1() throws SQLException{
		/*
		 * 使用DBUtil对Mysql数据库进行查询测试:
		 * author:qkmc@outlook.com
		 * */
		//首先获取数据库连接池对象
		ComboPooledDataSource ds = new ComboPooledDataSource();
		//调用连接池对象中的getcon方法获得链接     对数据库的配置在c3p0-config.xml文件中
		Connection con = ds.getConnection();
		
		String sql = "select * from user";
		//创建一个DBUTILS中的查询对象,用来进行查询
		QueryRunner querryRunner = new QueryRunner();
		//将查询的结果装在MapList中(dbutil封装的结果)
		List<Map<String,Object>> list = querryRunner.query(con, sql, new MapListHandler());
		//最后输出
		System.out.println("list: " + list);
	}
	
	
	/*
	 * m2用于测试封装的jdbcBuild
	 * DBConnection将使用c3p0链接数据库的DBUtil封装起来,使用单列模式提高数据库访问效率
	 * 而jdbcBuild又对DBConnection再次封装
	 * 这样子就可以在实际使用中像使用数据库查询一样的方式来访问数据库了!
	 * */
	@Test
	public void m2() throws SQLException{
		String sql = "select * from user";
		List<Map<String, Object>> list = findAllForList(sql);
		System.out.println(list);
	}
}






