package com.control;

import com.beans.user.NormalUser;

import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import com.beans.connect.*;

import java.io.PrintWriter;
import java.sql.*;

public class RegisterControlClass extends HttpServlet{

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    private void failPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<script>");
        out.print("alert(\"register fail !\");");
        out.print("window.location.href='register_user.jsp';");
        out.print("</script>");
        out.print("</html></body>");
    }

    private void successPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<script>");
        out.print("alert(\"register successful !\");");
        out.print("window.location.href='index.jsp';");
        out.print("</script>");
        out.print("</html></body>");
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String user_id =  req.getParameter("user_id");
        String name =  req.getParameter("name");
        String password =  req.getParameter("password");
        String sex =  req.getParameter("sex");
        String ageStr = req.getParameter("age");

        if( ageStr.matches("[0-9]+") == false )
        {
            failPage(req,resp);
            return;
        }
        int age =   Integer.parseInt( ageStr );

        if( age > 40 || age < 19)
        {
            failPage(req,resp);
            return ;
        }

        if(password.equals(""))
        {
            failPage(req,resp);
            return;
        }

        String privilege =  "user";
        ConnectMySQL mySQL = new ConnectMySQL();
        mySQL.startConnectSQL("jdbc:mysql://127.0.0.1:3306/account","root","root");
        StringBuffer stringBuffer = new StringBuffer();
        try{
            stringBuffer.setLength(0);
            stringBuffer.append("insert INTO user_information VALUES(");
            stringBuffer.append("'");
            stringBuffer.append(user_id);
            stringBuffer.append("',");

            stringBuffer.append("'");
            stringBuffer.append(name);
            stringBuffer.append("',");

            stringBuffer.append("'");
            stringBuffer.append(password);
            stringBuffer.append("',");

            stringBuffer.append("'");
            stringBuffer.append(sex);
            stringBuffer.append("',");

            stringBuffer.append(age);
            stringBuffer.append(",");

            stringBuffer.append("'");
            stringBuffer.append(privilege);
            stringBuffer.append("')");

            System.out.println(stringBuffer.toString());

           if( mySQL.insertInformation( stringBuffer.toString() ) == true )
           {
               mySQL.closeConnect();
               successPage(req,resp);
           }
            else
           {
               mySQL.closeConnect();
               failPage(req,resp);
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
