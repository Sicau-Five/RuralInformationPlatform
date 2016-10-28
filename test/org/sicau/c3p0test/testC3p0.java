package org.sicau.c3p0test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class testC3p0 {

	@Test
	public void test01() throws PropertyVetoException, SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
//		ds.setDriverClass("com.mysql.jdbc.Driver");
//		ds.setJdbcUrl("jdbc:mysql://localhost:3306/rip");
//		ds.setUser("root");
//		ds.setPassword("1314");
		Connection con = ds.getConnection();
		DatabaseMetaData dmd = con.getMetaData();
		String fuck = dmd.getDatabaseProductVersion();
		System.out.println(fuck+"fuck you everyday");
		
	}

}
