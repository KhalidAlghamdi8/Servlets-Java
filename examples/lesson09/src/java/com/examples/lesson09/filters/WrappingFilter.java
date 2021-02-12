package com.examples.lesson09.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

@WebFilter(filterName = "WrappingFilter", servletNames = {"FilteredServlet"})
public class WrappingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {

    RequestWrapper wrappedRequest = new RequestWrapper((HttpServletRequest) request);
    ResponseWrapper wrappedResponse = new ResponseWrapper((HttpServletResponse) response);

    chain.doFilter(wrappedRequest, wrappedResponse);
  }

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) {
  }

  class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
      super(request);
    }

    @Override
    public void setAttribute(String name, Object o) {
      if (o instanceof String) {
        super.setAttribute(name, "INTERCEPTED BY A FILTER");
      } else {
        super.setAttribute(name, o);
      }
    }
  }

  class ResponseWrapper extends HttpServletResponseWrapper {

    public ResponseWrapper(HttpServletResponse response) {
      super(response);
    }
  }
}
