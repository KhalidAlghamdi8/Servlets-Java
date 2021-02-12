package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CokkiesServlet", urlPatterns = {"/cookies"})
public class CookiesServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Cookies</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");

    if (cookies != null && cookies.length > 0) {
    out.println("<h1>Your cookies</h1>");
      out.println("<ul>");
      for (Cookie cookie : cookies) {
        out.println("<li>" + cookie.getName() + "=" + cookie.getValue() + "</li>");
      }
      out.println("</ul>");
    }else{
      out.println("<h1>Cookies set!</h1>");
      out.println("<p>Next time you visit this page cookies will be displayed</p>");
    }

    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");

    response.addCookie(new Cookie("chocochips", "chocochipsCookie"));
    response.addCookie(new Cookie("blueberry", "I like berries"));
  }
}
