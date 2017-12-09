package com.beans.connect;
import java.sql.*;
public class ConnectMySQL extends ConnectDataBase{


	public ConnectMySQL() {
		// TODO 自动生成的构造函数存根
		super();
	}
	@Override
	public synchronized void startConnectSQL(String url, String userAccount, String userPassword) {
		// TODO 自动生成的方法存根
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, userAccount, userPassword);
			sql = con.createStatement();
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDriverName());

		}
		catch (Exception e) 
		{
			System.out.println("无法连接！！");
			e.printStackTrace();
			
		}
	}

	@Override


	public synchronized void closeConnect()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	
}
