package com.control;

import com.beans.standardTest.Exam;

import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExamControlClass extends HttpServlet {
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        Exam exam = (Exam)session.getAttribute("exam");
        String Opt[] = new String[4];
        for (int i = 1; i <= 4; i++) {
            Opt[i - 1] = request.getParameter("Opt_" + String.valueOf(i));
        }
        for (int i = 0; i < 4; i++)
            System.out.println(Opt[i]);

        String trueAnswer[] = exam.getTrueAnswer().split(" ");
        System.out.println(exam.getTrueAnswer());
        exam.addCount();
        exam.clearScore();

        int trueNum = 0;

        for( int i = 0; i < 4; i++)
            if( trueAnswer[i].equals(Opt[i]) == true )
                trueNum ++;
        exam.setScore(trueNum*25);

        int score = exam.getScore();

        PrintWriter out = response.getWriter();
        //response.setContentType("text/html;charset=utf-8");
        out.print("<html><body>");
        out.print("<script>");
        if( exam.getCount() > 3 )
            out.print("alert(\"Only three times to be submitted!\");");
        else
            out.print("alert(\"your score is "+score+"!\" );");
        out.print("window.location.href='exam.jsp'; </script>");
        out.print("</html></body>");
    }
}
