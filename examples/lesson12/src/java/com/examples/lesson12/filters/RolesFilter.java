package com.examples.lesson12.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "RolesFilter", urlPatterns = {"/*"})
public class RolesFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {
    if (request instanceof HttpServletRequest) {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      String roles = "";
      if (httpRequest.isUserInRole("quizUser")) {
        roles += roles.length() == 0 ? "" : ", ";
        roles += "User";
      }
      if (httpRequest.isUserInRole("quizAdmin")) {
        roles += roles.length() == 0 ? "" : ", ";
        roles += "Administrator";
      }
      if (httpRequest.isUserInRole("quizInstructor")) {
        roles += roles.length() == 0 ? "" : ", ";
        roles += "Instructor";
      }
      httpRequest.setAttribute("userRoles", roles);
      httpRequest.setAttribute("userName", httpRequest.getRemoteUser());
    }
    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
