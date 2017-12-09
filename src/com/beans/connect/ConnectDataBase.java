package com.beans.connect;

import java.sql.*;

public abstract class ConnectDataBase {
	protected Connection con = null;
	protected Statement sql = null;
	protected ResultSet rs = null;

	public ConnectDataBase()
	{

	}

	abstract  public void startConnectSQL(String url, String userAccount, String userPassword);

	abstract  public void closeConnect();

	public synchronized  boolean updateInformation(String SQLUpdateCommand) {
		try {
			int judge  = sql.executeUpdate(SQLUpdateCommand);
			if( judge > 0 )
				return true;  //update successful
		}
		catch (Exception e)
		{
				e.printStackTrace();
		}
		return false;
	}

	public synchronized ResultSet selectInformation(String SQLSelectCommand)
	{
		try {
			rs = sql.executeQuery(SQLSelectCommand);

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
	}

	public synchronized  boolean insertInformation(String insertCommand)
	{
		try {
			int judge = sql.executeUpdate(insertCommand);
			if (judge > 0)
				return true;
		}
		catch (Exception e){

		}
		return false;
	}
}
