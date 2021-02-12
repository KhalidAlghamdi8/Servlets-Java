/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.lesson05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ScopesServletTest", urlPatterns = {"/ScopesServletTest"},
initParams = {
  @WebInitParam(name = "name", value = "servletConfig")
})
public class ScopesServletTest extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.setAttribute("name", "John");
    request.getSession().setAttribute("name", "Paul");
    getServletContext().setAttribute("name", "Steve");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet ScopesServletTest</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Scopes</h1>");
    out.println("<table>");
    out.println("<thead>");

    out.println("<tr>");
    out.println("<th>Scope</th>");
    out.println("<th>Value</th>");
    out.println("<th>How to set it?</th>");
    out.println("</tr>");
    out.println("</thead>");

    out.println("<tr>");
    out.println("<td>request.getParameter(\"name\")</td>");
    out.println("<td>" + request.getParameter("name") + "</td>");
    out.println("<td>Sent from forms or url.</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>request.getAttribute(\"name\")</td>");
    out.println("<td>" + request.getAttribute("name") + "</td>");
    out.println("<td>set programatically using request.setAttribute</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>session.getAttribute(\"name\")</td>");
    out.println("<td>" + request.getSession().getAttribute("name") + "</td>");
    out.println("<td>set programatically using session.setAttribute</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>servletConfig.getInitParameter(\"name\")</td>");
    out.println("<td>" + getServletConfig().getInitParameter("name") + "</td>");
    out.println("<td>Declared in web.xml or as annotations in the servlet</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>servletContext.getInitParameter(\"name\")</td>");
    out.println("<td>" + getServletContext().getInitParameter("name") + "</td>");
    out.println("<td>Declared in web.xml</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>servletContext.getAttribute(\"name\")</td>");
    out.println("<td>" + getServletContext().getAttribute("name") + "</td>");
    out.println("<td>set programatically using servletContext.setAttribute</td>");
    out.println("</tr>");

    out.println("</table>");
    out.println("</body>");
    out.println("<a href=\"home.html\">Go Home</a>");
    out.println("</html>");
  }
}
