package com.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.beans.connect.ConnectMySQL;
import com.beans.user.NormalUser;
public class UpdatePwdControlClass extends HttpServlet
{
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    private void successPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<script>");

        out.print("alert(\"update successful !\");");
        out.print("window.parent.location.href='index.jsp';");
        out.print("</script>");
        out.print("</html></body>");
    }
    private void failPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<script>");

        out.print("alert(\"update fail !\");");
        out.print("window.location.href='update_password.jsp';");
        out.print("</script>");
        out.print("</html></body>");
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String oldPwd = request.getParameter("oldPwd");
        String newPwd = request.getParameter("newPwd");
        HttpSession session = request.getSession();
        NormalUser user = (NormalUser)session.getAttribute("user");
        if( oldPwd.equals( user.getPassword() ) == true)
        {
            if( newPwd.length() == 0)   //如果没有输入新密码直接更改
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("update_password.jsp");
                dispatcher.forward(request,response);
                return ;
            }
            for( int i = 0; i < newPwd.length(); i++ )
            {
                if( newPwd.charAt(i) == ' ' )
                {
                    failPage(request,response);
                    return ;
                }
            }

            StringBuffer stringBuffer = new StringBuffer();
            ConnectMySQL mySQL = new ConnectMySQL();
            mySQL.startConnectSQL("jdbc:mysql://127.0.0.1:3306/account","root","root");
            stringBuffer.append("update user_information set password = \'");
            stringBuffer.append(newPwd);
            stringBuffer.append("\' where user_id = \'");
            stringBuffer.append(user.getUser_id());
            stringBuffer.append("\'");
            mySQL.updateInformation(stringBuffer.toString());
            mySQL.closeConnect();
            successPage(request,response);
        }
        else{
            failPage(request,response);
        }
    }

}
