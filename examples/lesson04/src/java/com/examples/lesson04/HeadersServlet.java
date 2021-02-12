package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HeadersServlet", urlPatterns = {"/headers"})
public class HeadersServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Headers</title>");
      out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Request Headers</h1>");
      out.println("<table>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>Header Name</th>");
      out.println("<th>Header Value</th>");
      out.println("</tr>");
      out.println("</thead>");

      out.println("<tbody>");

      Enumeration<String> requestHeaderNames = request.getHeaderNames();
      while (requestHeaderNames.hasMoreElements()) {
        String headerName = requestHeaderNames.nextElement();
        Enumeration<String> headerValues = request.getHeaders(headerName);
        if (headerValues.hasMoreElements()) {
          while (headerValues.hasMoreElements()) {
            String headerValue = headerValues.nextElement();
            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
          }
        } else {
          out.println("<tr>");
          out.println("<td>" + headerName + "</td>");
          out.println("<td>&nbsp;</td>");
          out.println("</tr>");
        }
      }
      out.println("</tbody>");

      out.println("</table>");

      out.println("<h1>Response Headers</h1>");
      out.println("<table>");

      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>Header Name</th>");
      out.println("<th>Header Value</th>");
      out.println("</tr>");
      out.println("</thead>");

      out.println("<tbody>");
      for (String headerName : response.getHeaderNames()) {
        Collection<String> headerValues = response.getHeaders(headerName);
        if (!headerValues.isEmpty()) {
          for (String headerValue : headerValues) {
            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
          }
        } else {
          out.println("<tr>");
          out.println("<td>" + headerName + "</td>");
          out.println("<td>&nbsp;</td>");
          out.println("</tr>");
        }
      }
      out.println("</tbody>");

      out.println("</table>");
      out.println("<a href=\"index.html\">Go Home</a>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
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
