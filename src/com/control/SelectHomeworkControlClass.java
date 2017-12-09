package com.control;

import com.beans.homeworkSelect.HomeworkSelect;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SelectHomeworkControlClass  extends HttpServlet{
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        HomeworkSelect homeworkSelect = (HomeworkSelect)session.getAttribute("homework");
        homeworkSelect.select();
        out.print("<html><body>");
        out.print("<script>window.location.href='HomeWorkSelect.jsp';</script>");
        out.print("</html></body>");
    }
}
