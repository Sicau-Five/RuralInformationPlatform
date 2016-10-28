package org.sicau.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.sicau.util.DBConnection;


public abstract class jdbcBuild {
	
	/**
	 * ͳһ��ѯ�������List����
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findAllForList(String sql,Object... params) throws SQLException{
		Connection con = DBConnection.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		List<Map<String, Object>> list = new ArrayList<>();
		list = queryRunner.query(con,sql, new MapListHandler(),params);
		DBConnection.closeConnection();
		return list;
	}
	
	/*
	 * ��ѯ�û� ���ز�ѯ���ĸ���
	 * @return int
	 * */
	public int findAllForInt(String sql, Object... params) throws SQLException{
		Connection con = DBConnection.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		int i = queryRunner.query(con, sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet rs) throws SQLException {
				while(rs.next()){
					return rs.getInt(1);
				}
				return 0;
			}
			
		},params);
		DBConnection.closeConnection();
		return i;
	}
	
	
	
	
}
