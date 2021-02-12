package com.examples.lesson05.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ExampleContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().setAttribute("listenerValue", "Context Listener Value");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}
