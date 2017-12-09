package com.beans.connect;

import java.sql.*;

public class ConnectSQLServer extends ConnectDataBase{

	public ConnectSQLServer() {
		// TODO 自动生成的构造函数存根
	}
	@Override
	/**String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	 *  "databaseName=AdventureWorks;integratedSecurity=true;";
	 */
	public void startConnectSQL(String url, String userAccount, String userPassword) {
		// TODO 自动生成的方法存根
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, userAccount, userPassword);
			sql=con.createStatement();
		}
		catch (Exception e)
		{
			System.out.println("连接失败！");
			e.printStackTrace();
		}

	}
	
	@Override
	public void closeConnect() {
		// TODO 自动生成的方法存根
		try{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
