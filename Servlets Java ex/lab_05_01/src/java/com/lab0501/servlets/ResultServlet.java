package com.lab0501.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(
name="ResultServlet",urlPatterns = {"/Result"},
        initParams = {
            @javax.servlet.annotation.WebInitParam(name="title", value="Poll Results")
}
        
)
public class ResultServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String appName = getServletContext().getInitParameter("appName");
    String title = getServletConfig().getInitParameter("title");

    String pollName = request.getParameter("poll");
    String voted = request.getParameter("voted");

    PollCollection polls = (PollCollection) getServletContext().getAttribute("polls");
    Poll poll = polls.getPoll(pollName);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + appName + ": " + title + "</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>" + title + "</h1>");

    if ("true".equals(voted)) {
      out.println("<h2>You already voted in this poll</h2>");
    }

    out.println("<h2>Poll results.</h2>");
    out.println("<h3>" + poll.getName() + "</h3>");
    out.println("<ul>");
    for (Map.Entry<String, Integer> vote : poll.getVotes()) {
      out.println("<li>" + vote.getKey() + ":" + vote.getValue() + "</li>");
    }
    out.println("</ul>");

    out.println("<a href=\"home.html\">Go home</a>");

    out.println("</body>");
    out.println("</html>");
    
    response.addCookie( new Cookie(appName, voted));
      Cookie[] allCookies = request.getCookies();
      out.println("<h2> All Cookies");
      for (Cookie c:allCookies ){
      out.println("<h3>" +c.getName()+ " : " +c.getValue()+ "</h3>");
      }

  }
}
