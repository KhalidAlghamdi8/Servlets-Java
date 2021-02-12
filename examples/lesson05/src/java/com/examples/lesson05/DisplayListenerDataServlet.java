package com.examples.lesson05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayListenerDataServlet", urlPatterns = {"/displayListenerData"})
public class DisplayListenerDataServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Listener test.</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>This data was set by listeners</h1>");
    out.println("<table>");
    out.println("<thead>");

    out.println("<tr>");
    out.println("<th>Scope</th>");
    out.println("<th>Value</th>");
    out.println("<th>Who set it?</th>");
    out.println("</tr>");

    out.println("</thead>");

    out.println("<tr>");
    out.println("<td>servletContext.getAttribute(\"attributeCount\")</td>");
    out.println("<td>" + getServletContext().getAttribute("attributeCount") + "</td>");
    out.println("<td>ExampleContextAttributeListener keeps the count of elements inside the servlet context</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>servletContext.getAttribute(\"listenerValue\")</td>");
    out.println("<td>" + getServletContext().getAttribute("listenerValue") + "</td>");
    out.println("<td>ExampleContextListener sets this value when the application starts</td>");
    out.println("</tr>");

    request.setAttribute("demo", "nothing");

    out.println("<tr>");
    out.println("<td>request.getAttribute(\"attributeCount\")</td>");
    out.println("<td>" + request.getAttribute("attributeCount") + "</td>");
    out.println("<td>ExampleRequestAttributeListener keeps the count of the elements inside the request attributes.<br>");
    out.println("*Only attributes set in filters and servlets are counted, attributes set in listeners are not counted.</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>request.getAttribute(\"requestCount\")</td>");
    out.println("<td>" + request.getAttribute("requestCount") + "</td>");
    out.println("<td>ExampleRequestListener keeps the count of the requests made to the server.</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>session.getAttribute(\"attributeCount\")</td>");
    out.println("<td>" + request.getSession().getAttribute("attributeCount") + "</td>");
    out.println("<td>ExampleSessionAttributeListener keeps the count of the elements inside the session attributes.</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>session.getAttribute(\"sessionValue\")</td>");
    out.println("<td>" + request.getSession().getAttribute("sessionValue") + "</td>");
    out.println("<td>ExampleSessionListener adds some objects to the session.</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>session.getAttribute(\"valueBound\")</td>");
    out.println("<td>" + request.getSession().getAttribute("valueBound") + "</td>");
    out.println("<td>ExampleSessionBindingListener is a session aware bean that sets its value when bound to a session.<br>");
    out.println("This object is added to the session in: ExampleSessionListener</td>");
    out.println("</tr>");

    out.println("</table>");
    out.println("</body>");
    out.println("<a href=\"home.html\">Go Home</a>");
    out.println("</html>");

  }
}
