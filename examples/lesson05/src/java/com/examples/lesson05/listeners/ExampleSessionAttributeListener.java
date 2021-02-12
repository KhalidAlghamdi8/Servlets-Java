package com.examples.lesson05.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ExampleSessionAttributeListener implements HttpSessionAttributeListener {

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    HttpSession session = event.getSession();
    Integer count = (Integer) session.getAttribute("attributeCount");
    if (count == null) {
      count = 0;
    }
    count++;
    session.setAttribute("attributeCount", count);
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent event) {
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent event) {
  }
}
