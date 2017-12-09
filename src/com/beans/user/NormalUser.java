package com.beans.user;

public class NormalUser {

	protected String user_id;
	protected String name;
	protected String password;
	protected String sex;
	protected int age;
	protected String privilege;
	public NormalUser()
	{
		
	}

	public void setUser_id( String user_id )
	{
		this.user_id = user_id;
	}

	public NormalUser(String user_id,  String name,String password, String sex, int age ,String privilege ) {
		// TODO 自动生成的构造函数存根
		this.user_id  = user_id;
		this.name     = name;
		this.password = password;
		this.sex	  = sex;
		this.age      = age;
		this.privilege= privilege;
	}
	public String getUser_id()
	{
		return user_id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSex()
	{
		return sex;
	}
	public int getAge()
	{
		return age;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getPrivilege()
	{
		return privilege;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
