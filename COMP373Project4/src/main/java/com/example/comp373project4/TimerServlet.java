package com.example.comp373project4;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "timerServlet", value = "/timer-servlet")
public class TimerServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        message = "Counting down...";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        Timer timer = new Timer();
        //timer.


    }

    public void destroy() {
    }
}