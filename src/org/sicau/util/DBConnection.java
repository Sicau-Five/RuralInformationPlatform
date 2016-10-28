package org.sicau.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/*在这个类钟,这是使用单列模式设计的类,加强对数据库访问的效率,对外只提供获取链接和关闭链接的方法,对数据库的配置依然是c3p0-config.xml来完成的!*/
/**
 * 利用Java中单例设计模式完成对数据库连接池的封装
 * 目的：
 * 1. 保证DBConnection类为外部其他提供唯一一个实例对象
 * 2. 保证将DataSource数据源能够不暴露给外部类使用
 * 3. 保证提供统一的Connection会话对象
 * 4. 保证提供统一的Connection对象的资源关闭的操作
 * @author Administrator
 *
 */
public class DBConnection {
	private static DBConnection db = null;
	private static DataSource ds = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/**
	 * 初始化DataSource的对象，因为没有DataSource对象则就不可能产生Connection对象
	 */
	private DBConnection() {
		ds = new ComboPooledDataSource();
	}
	
	private final static DBConnection getInstance() {
		if (db == null) {
			synchronized (DBConnection.class) { //线程中同步加锁，在多线程情况下去访问DBConnection的对象，保证资源不冲突
				db = new DBConnection();
			}
		}
		return db;
	}
	
	/**
	 * 获取数据库的会话
	 * @return
	 * @throws SQLException 
	 */
	private final Connection connection() throws SQLException {
		Connection conn = tl.get(); //通过线程来获取当前线程中的数据库会话对象
		if (conn == null) {
			conn = ds.getConnection();
			tl.set(conn); //将新的Connection对象放入到线程里面
		}
		return conn;
	}
	
	/**
	 * 对数据库的会话进行资源的关闭
	 * @throws SQLException
	 */
	private final void close() throws SQLException {
		Connection conn = tl.get();
		if (conn != null && !conn.isClosed()) {
			conn.close();
			tl.remove();
		}
	}
	
	/**
	 * 供外部访问Connection对象的方法
	 * @return
	 * @throws SQLException
	 */
	public synchronized final static Connection getConnection() throws SQLException {
		return getInstance().connection();
	}
	
	/**
	 * 供外部关闭会话对象的方法
	 * @throws SQLException
	 */
	public synchronized final static void closeConnection() throws SQLException {
		getInstance().close();
	}
}