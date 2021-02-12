package com.examples.lesson05.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ExampleRequestListener implements ServletRequestListener {

  int requestCount = 0;

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    requestCount++;
    sre.getServletRequest().setAttribute("requestCount", requestCount);
  }
}
