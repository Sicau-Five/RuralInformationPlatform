package org.sicau.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {

	@Test
	public void m01() throws SQLException{
		System.out.println("--------------------------------------------------------------------------");
		ComboPooledDataSource ds = new ComboPooledDataSource();
		System.out.println("--------------------------------------------------------------------------");

		Connection con = ds.getConnection();
		System.out.println("--------------------------------------------------------------------------");

		DatabaseMetaData dmd = con.getMetaData();
		System.out.println("--------------------------------------------------------------------------");

		String product = dmd.getDatabaseProductVersion();
		System.out.println("product version: " + product);
		
	}
}
