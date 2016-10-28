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
		 * ʹ��DBUtil��Mysql���ݿ���в�ѯ����:
		 * author:qkmc@outlook.com
		 * */
		//���Ȼ�ȡ���ݿ����ӳض���
		ComboPooledDataSource ds = new ComboPooledDataSource();
		//�������ӳض����е�getcon�����������     �����ݿ��������c3p0-config.xml�ļ���
		Connection con = ds.getConnection();
		
		String sql = "select * from user";
		//����һ��DBUTILS�еĲ�ѯ����,�������в�ѯ
		QueryRunner querryRunner = new QueryRunner();
		//����ѯ�Ľ��װ��MapList��(dbutil��װ�Ľ��)
		List<Map<String,Object>> list = querryRunner.query(con, sql, new MapListHandler());
		//������
		System.out.println("list: " + list);
	}
	
	
	/*
	 * m2���ڲ��Է�װ��jdbcBuild
	 * DBConnection��ʹ��c3p0�������ݿ��DBUtil��װ����,ʹ�õ���ģʽ������ݿ����Ч��
	 * ��jdbcBuild�ֶ�DBConnection�ٴη�װ
	 * �����ӾͿ�����ʵ��ʹ������ʹ�����ݿ��ѯһ���ķ�ʽ���������ݿ���!
	 * */
	@Test
	public void m2() throws SQLException{
		String sql = "select * from user";
		List<Map<String, Object>> list = findAllForList(sql);
		System.out.println(list);
	}
}






