package com.lab0501.listener;

import com.lab0501.servlets.PollCollection;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PollInitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("polls", new PollCollection());
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}
