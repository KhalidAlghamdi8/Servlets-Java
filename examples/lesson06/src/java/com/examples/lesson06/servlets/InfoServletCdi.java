package com.examples.lesson06.servlets;

import com.examples.lesson06.services.InfoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InfoServletCdi", urlPatterns = {"/infoCdi"})
public class InfoServletCdi extends HttpServlet {

  @Inject
  private InfoService infoService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet InfoServletCdi</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>System information</h1>");
    out.println("<ul>");
    out.println("<li>Server Name: " + infoService.calculateServerName() + "</li>");
    out.println("<li>Server Memory: " + infoService.calculateServerMemory() + "</li>");
    out.println("<li>Server FreeMemory: " + infoService.calculateServerFreeMemory() + "</li>");
    out.println("<li>Server Cores: " + infoService.calculateServerCores() + "</li>");
    out.println("<li>Server Time: " + infoService.calculateServerTime() + "</li>");
    out.println("</ul>");
    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
