package com.examples.lesson05.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ExampleRequestAttributeListener implements ServletRequestAttributeListener {

  @Override
  public void attributeAdded(ServletRequestAttributeEvent srae) {
    ServletRequest request = srae.getServletRequest();
    Integer count = (Integer) request.getAttribute("attributeCount");
    if (count == null) {
      count = 0;
    }
    count++;
    request.setAttribute("attributeCount", count);

  }

  @Override
  public void attributeRemoved(ServletRequestAttributeEvent srae) {
  }

  @Override
  public void attributeReplaced(ServletRequestAttributeEvent srae) {
  }
}
