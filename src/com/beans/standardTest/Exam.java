package com.beans.standardTest;

import com.beans.user.*;
import java.io.*;
import java.util.Random;
import javax.servlet.http.*;

public class Exam {
	private String fileName = "";		//文件名称
	private NormalUser user;			//用户
	private String testContent="";	//测试内容数组
	private String trueAnswer="";		//正确答案
	private String userAnswer="";		//用户答案
	private int count = 0;
	private int score = 0;

	public void setUser( NormalUser user ){
		this.user = user;
	}
	public Exam() {
		// TODO 自动生成的构造函数存根
	}

	public void getFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public void addCount()
	{
		this.count ++;
	}

	public void clearCount()
	{
		this.count = 0;
	}



	public int getCount()
	{
		return count;
	}

	public void readTextFile() throws  IOException
	{
		StringBuffer stringBuffer = new StringBuffer();

		FileInputStream fileInputStream = new FileInputStream("G:\\echo\\TestDoc\\"+fileName);
		InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream,"UTF-8");

		BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

		String buff;
		if( ( buff = bufferedReader.readLine()  ) != null)
			trueAnswer = buff;			//read standard answer
		else
			return ;
		while( (  buff = bufferedReader.readLine()  ) != null ) {
			stringBuffer.append(buff + "\n");
		}
		testContent = stringBuffer.toString();

		bufferedReader.close();
		inputStreamReader.close();;
		fileInputStream.close();
	}

	public String getResult()
	{
		Random random = new Random(System.currentTimeMillis());
		String fileTbl[] = {"A","B"};
		StringBuffer stringBuffer = new StringBuffer();
		String option[];
		String test[];
		int idx = random.nextInt(2);
		fileName = fileTbl[idx] + ".txt";
		try
		{
			readTextFile();
			test = testContent.split("\n");
			option = readTestOption( fileTbl[idx] + "_Option.txt" );
			for( int i = 0; i < test.length; i++ )
			{
				stringBuffer.append("<div class = \"Text_Frame\" >");
				stringBuffer.append("<table class = \"Text_Table\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\"  bordercolor=\"#FBFBFB\" >");
				stringBuffer.append("<tr class=\"Text_Table_Row1\">");
				stringBuffer.append("<td >");
				stringBuffer.append("&nbsp&nbsp" + (i + 1) + "." + "&nbsp&nbsp" + test[i]);
				stringBuffer.append("</td>");
				stringBuffer.append("</tr>");
				stringBuffer.append("<tr class=\"Text_Table_Row2\" border=\"0\">");
				stringBuffer.append("<td >");
				for (int j = i << 2; j < option.length && j <= (i << 2) + 3; j++)
				{
					stringBuffer.append(option[j] + "<br>");
				}
				stringBuffer.append("</td>");
				stringBuffer.append("</tr>");
				stringBuffer.append("</table>");
				stringBuffer.append("</div>");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}

	public String[] readTestOption( String testOption ) throws Exception	//读取选项文件
	{

		StringBuffer stringBuffer = new StringBuffer();

		System.out.println();

		FileInputStream fileInputStream = new FileInputStream("G:\\echo\\TestDoc\\"+testOption);

		InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream,"UTF-8");

		BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

		String buff;

		while( (  buff = bufferedReader.readLine()  ) != null ) {
			stringBuffer.append(buff + "\n");
		}
		String[] str = stringBuffer.toString().split("\n");
		bufferedReader.close();
		inputStreamReader.close();;
		fileInputStream.close();
		return str;
	}

	public void setUserAnswer(String userAnswer)
	{
		this.userAnswer = userAnswer;
	}

	public String getTestContent()
	{
		return this.testContent;
	}

	public void clearScore()
	{
		score = 0;
	}

	public int getScore()
	{
		return  this.score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public String getTrueAnswer(){
		return trueAnswer;
	}
}
