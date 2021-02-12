package com.examples.lesson05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnnotationConfigServlet",
urlPatterns = {"/AnnotationConfigServlet"},
initParams = {
  @WebInitParam(name = "ServletName", value = "Annotation Configured Servlet"),
  @WebInitParam(name = "WelcomeMessage", value = "Welcome")
})
public class AnnotationConfigServlet extends HttpServlet {

  private String servletName;

  @Override
  public void init() throws ServletException {
    servletName = getServletConfig().getInitParameter("Welcome");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String welcomeMessage = getServletConfig().getInitParameter("WelcomeMessage");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet AnnotationConfigServlet</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>" + welcomeMessage + "</h1>");
    out.println("<a href=\"home.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void destroy() {
    System.out.print("SERVLET DESTROYED");
  }
}
