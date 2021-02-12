package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParametersServlet", urlPatterns = {"/params"})
public class ParametersServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet ParametersServlet</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Parameters sent to this servlet </h1>");

    out.println("<table>");

    out.println("<thead>");
    out.println("<tr>");
    out.println("<th>Parameter Name</th>");
    out.println("<th>Parameter Value</th>");
    out.println("</tr>");
    out.println("</thead>");

    out.println("<tbody>");
    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String[] paramValues = request.getParameterValues(paramName);
      out.println("<tr>");
      out.println("<td>" + paramName + "</td>");
      out.println("<td>" + Arrays.toString(paramValues) + "</td>");
      out.println("</tr>");
    }
    out.println("</tbody>");

    out.println("</table>");

    out.println("<a href=\"servletParams.html\">Go Back</a> ");
    out.println("<a href=\"index.html\">Go Home</a>");

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }
}
