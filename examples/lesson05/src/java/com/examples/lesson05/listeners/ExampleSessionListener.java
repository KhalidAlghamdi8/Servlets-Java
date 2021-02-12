package com.examples.lesson05.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class ExampleSessionListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    session.setAttribute("sessionValue", "Started!");
    session.setAttribute("valueBound", new ExampleSessionBindingListener());
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
  }
}
