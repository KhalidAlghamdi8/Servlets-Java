package com.examples.lesson05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlConfigServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    ServletContext servletContext = getServletContext();
    ServletConfig servletConfig = getServletConfig();

    String applicationName = servletContext.getInitParameter("application-name");
    String servletName = servletConfig.getInitParameter("servlet-name");
    String servletWelcomeMessage = servletConfig.getInitParameter("welcome-message");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + servletName + "</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>" + applicationName + "</h1>");
    out.println("<h2>" + servletWelcomeMessage + "</h2>");
    out.println("<a href=\"home.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
