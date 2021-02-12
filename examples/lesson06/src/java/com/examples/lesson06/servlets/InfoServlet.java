package com.examples.lesson06.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InfoServlet", urlPatterns = {"/info"})
public class InfoServlet extends HttpServlet {

  private static final String SERVER_NAME = "TEST SERVER";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String serverName = SERVER_NAME;
    String serverMemory = formatBytes(Runtime.getRuntime().maxMemory());
    String serverFreeMemory = formatBytes(Runtime.getRuntime().freeMemory());
    String serverCores = Integer.toString(Runtime.getRuntime().availableProcessors());
    String serverTime = new SimpleDateFormat().format(new Date());

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet InfoServlet</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>System information</h1>");
    out.println("<ul>");
    out.println("<li>Server Name: " + serverName + "</li>");
    out.println("<li>Server Memory: " + serverMemory + "</li>");
    out.println("<li>Server FreeMemory: " + serverFreeMemory + "</li>");
    out.println("<li>Server Cores: " + serverCores + "</li>");
    out.println("<li>Server Time: " + serverTime + "</li>");
    out.println("</ul>");
    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }

  private String formatBytes(long bytes) {
    if (bytes < 1024) {
      return bytes + "B";
    }
    if (bytes < 1024 * 1024) {
      return (bytes / 1024) + "KB";
    }
    return (bytes / (1024 * 1024)) + "MB";
  }
}
