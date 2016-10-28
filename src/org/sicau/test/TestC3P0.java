package org.sicau.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {

	@Test
	public void m01() throws SQLException{
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection con = ds.getConnection();
		DatabaseMetaData dmd = con.getMetaData();
		String product = dmd.getDatabaseProductVersion();
		System.out.println("product version: " + product);
		
	}
}
