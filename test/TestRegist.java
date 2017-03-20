import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.sicau.util.DBConnection;


public class TestRegist {
	
	
	@Test
	public void m1() throws SQLException{
		Object[] params = {"sfs","asdqw","qdqw","dqdwq"};
		Connection con = DBConnection.getConnection();
		String sql = "insert into user(userid,username,userpwd,email)values(?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		int i = queryRunner.update(con, sql, params);//插入一条记录
		if(i == 1){System.out.println("fuck success");}else{System.out.println("fuck failed");}
	}
}
