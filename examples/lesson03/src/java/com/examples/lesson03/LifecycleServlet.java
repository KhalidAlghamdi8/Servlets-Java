package com.examples.lesson03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LifecycleServlet", urlPatterns = {"/servlets/LifecycleServlet"})
public class LifecycleServlet extends HttpServlet {

  private int order = 0;
  private String initString = "";
  private String postConstructString = "";

  @PostConstruct
  public void afterDependencyInjection() {
    order++;
    postConstructString = "Step " + Integer.toString(order);
    try {
      getServletContext();
      postConstructString += " Has the servletContext!";
    } catch (IllegalStateException e) {
      postConstructString += " Cannot get the servletContext!";
    }
    System.out.println("PostConstruct invoked: " + postConstructString);
  }

  @Override
  public void init() throws ServletException {
    order++;
    initString = "Step " + Integer.toString(order);
    try {
      getServletContext();
      initString += " Has the servletContext!";
    } catch (IllegalStateException e) {
      initString += " Cannot get the servletContext!";
    }
    System.out.println("init invoked: " + initString);
  }

  @Override
  public void destroy() {
    order++;
    System.out.println("destroy invoked: Step:" + order);
  }

  @PreDestroy
  public void beforeBeanDestruction() {
    order++;
    System.out.println("PreDestroy invoked: Step:" + order);

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet LifecycleServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet LifecycleServlet at " + request.getContextPath() + "</h1>");
      out.println("<h2>PostConstruct: " + postConstructString + "</h2>");
      out.println("<h2>Init: " + initString + "</h2>");
      out.println("<p>Order of execution: PostConstruct(s), init method, destroy method, PreDestroy(s)</p>");

      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }
}
