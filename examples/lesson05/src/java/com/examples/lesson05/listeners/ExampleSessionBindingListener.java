package com.examples.lesson05.listeners;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// Does not need web.xml configuration. Runs automatically when object is bound to a session.
public class ExampleSessionBindingListener implements HttpSessionBindingListener {

  private String value = null;

  @Override
  public void valueBound(HttpSessionBindingEvent event) {
    value = "object is bound to session!";
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
  }

  public String toString() {
    return value;
  }
}
