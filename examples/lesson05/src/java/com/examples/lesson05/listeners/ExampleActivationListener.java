package com.examples.lesson05.listeners;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

// Does not need web.xml configuration
// Must be part of an object that is session aware and will be called automatically.
public class ExampleActivationListener implements HttpSessionActivationListener {

  @Override
  public void sessionWillPassivate(HttpSessionEvent se) {
    // Do some logic when a session is going to be serialized.
  }

  @Override
  public void sessionDidActivate(HttpSessionEvent se) {
    // Do some logic when a session has been de-serialized.
  }
}
