package com.examples.lesson05.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ExampleContextAttributeListener implements ServletContextAttributeListener {

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    ServletContext servletContext = event.getServletContext();
    Integer count = (Integer) servletContext.getAttribute("attributeCount");
    if (count == null) {
      count = 0;
    }
    count++;
    servletContext.setAttribute("attributeCount", count);
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
  }
}
