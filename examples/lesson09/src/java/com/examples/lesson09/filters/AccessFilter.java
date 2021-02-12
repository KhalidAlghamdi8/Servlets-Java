package com.examples.lesson09.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "AccessFilter", urlPatterns = { //Several filtered patterns
  "/page_header.jsp",
  "/page_footer.jsp",
  "/accessDenied.jsp"
})
public class AccessFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {
    // The filtered resources are considered restricted.
    // Just redispatch instead of following the chain.
    request.getRequestDispatcher("accessDenied.jsp").forward(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
