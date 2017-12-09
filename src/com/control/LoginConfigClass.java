package com.control;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.beans.connect.*;
import com.beans.user.NormalUser;
import java.sql.*;

public class LoginConfigClass extends HttpServlet {
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
       ConnectMySQL MySQL = new  ConnectMySQL();
       MySQL.startConnectSQL( "jdbc:mysql://127.0.0.1:3306/account","root","root" );
       NormalUser temp = new NormalUser();
       String account  = request.getParameter("ac");
       String password = request.getParameter("pw");
       if( account != null && !account.equals("") && !password.equals("") )
       {
           StringBuffer selectCommand = new StringBuffer();
           try
           {
                   selectCommand.append("select * from user_information where user_id = ");
                   selectCommand.append("\'");
                   selectCommand.append(account);
                   selectCommand.append("\'");
                   ResultSet result = MySQL.selectInformation(selectCommand.toString());    //从数据库读取一条信息
                   System.out.print(result);
                   while (result.next())
                   {
                       temp = new NormalUser(
                               result.getString("user_id"),
                               result.getString("name"),
                               result.getString("password"),
                               result.getString("sex"),
                               Integer.parseInt(result.getString("age")),
                               result.getString("privilege")
                       );
                   }//将丛书据库读取的信息存入缓冲区变量temp


                   if( temp != null )
                   {
                       if( temp.getUser_id() == null )	//如果查无此人
                       {
                           MySQL.closeConnect();
                           RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                           dispatcher.forward(request,response);
                       }
                       if( temp.getUser_id().equals(account) == true )	//如果存在该用户
                       {
                           if( temp.getPassword().equals(password) != true )	//如果密码错误，返回到index.jsp重新登陆
                           {
                               RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                               dispatcher.forward(request,response);
                               MySQL.closeConnect();
                           }
                           else
                           {
                               HttpSession session = request.getSession();
                               session.setAttribute("user",temp);
                               RequestDispatcher dispatcher = request.getRequestDispatcher("user_information.jsp");
                               dispatcher.forward(request,response);
                               MySQL.closeConnect();
                           }
                       }
                   }
                   else
                   {
                       RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                       dispatcher.forward(request,response);
                   }

           }
           catch (SQLException e)
           {
                e.printStackTrace();
           }
       }
       else
       {
           RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
           dispatcher.forward(request,response);
           MySQL.closeConnect();
       }



   }
}
