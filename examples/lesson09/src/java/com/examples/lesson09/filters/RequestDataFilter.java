package com.examples.lesson09.filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "RequestDataFilter", urlPatterns = {"*.jsp"},
initParams = {
  @WebInitParam(name = "server-name", value = "Example Server")
})
public class RequestDataFilter implements Filter {

  private String serverName;
  private long lastExecTime = 0;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {
    Date now = new Date();

    request.setAttribute("server-name", serverName);
    request.setAttribute("server-date", new SimpleDateFormat("dd MMM yyyy").format(now));
    request.setAttribute("server-time", new SimpleDateFormat("HH:mm:ss.SSS").format(now));
    request.setAttribute("server-lastExecTime", lastExecTime);

    long startTime = now.getTime();
    chain.doFilter(request, response);
    lastExecTime = System.currentTimeMillis() - startTime;

  }

  @Override
  public void destroy() {
    serverName = null;
  }

  @Override
  public void init(FilterConfig filterConfig) {
    serverName = filterConfig.getInitParameter("server-name");
  }
}
