package org.sicau.c3p0test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class testC3p0 {

	@Test
	public void test() throws SQLException, ClassNotFoundException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection con = ds.getConnection();
		DatabaseMetaData md = con.getMetaData();
		String fuck = md.getDatabaseProductName();
		System.out.println(fuck+"cao ni ma");
		System.out.println("cg");
		
	}

}
