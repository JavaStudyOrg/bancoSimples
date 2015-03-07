package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SingletonGenerico {
	
	private static SingletonGenerico instance;
	private static Connection con;
	private static String dburl;
	
	private SingletonGenerico()	{
		con = null;
		dburl = "";
		instance = null;
	}
	
	public static synchronized SingletonGenerico getInstance() {
		if(instance == null)
			instance = new SingletonGenerico();
		
		return instance;		
	}
	
	public void setUrl(String url) {
		dburl = url;
	}
		
	private Connection getConnection() throws SQLException {
		con = null;
		
		con = DriverManager.getConnection(dburl);
				
		return con;
	}
	
	private void closeConnection() throws SQLException {
		try {
			con.close();
		} catch (SQLException error) {
			error.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	public boolean insert(String query) throws SQLException {
		boolean ret = false;
		
		con = null;
		
		try {
			PreparedStatement prepared = null;
			
			con = getConnection();
			prepared = con.prepareStatement(query);
			ret = prepared.execute();
			
		} catch (SQLException error) {
			error.printStackTrace();
		} finally {
			closeConnection();
		}
		
		return ret;
	}
	
	public ResultSet select(String query) throws SQLException {
		ResultSet ret = null;
		
		con = null;
		
		try {
			PreparedStatement prepared = null;
			
			con = getConnection();
			prepared = con.prepareStatement(query);
			ret = prepared.executeQuery();			
		} catch (SQLException error) {
			error.printStackTrace();
		} finally {
			closeConnection();
		}		
		
		return ret;
	}
	
	public boolean delete(String query) throws SQLException {
		boolean ret = false;
		
		try {
			PreparedStatement prepared = null;
			
			con = getConnection();
			prepared = con.prepareStatement(query);
			ret = prepared.execute();
		} catch (SQLException error) {
			error.printStackTrace();
		} finally {
			closeConnection();
		}
		
		return ret;
	}	
}
