package com.examples.lesson10.servlets.listeners;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;

public class HelloAsyncListener implements AsyncListener {

  @Override
  public void onComplete(AsyncEvent event) throws IOException {
    Logger.getLogger(HelloAsyncListener.class.getName()).log(Level.INFO, "Async Completed");
  }

  @Override
  public void onTimeout(AsyncEvent event) throws IOException {
    Logger.getLogger(HelloAsyncListener.class.getName()).log(Level.WARNING, "Async timed out");
    event.getAsyncContext().complete();
  }

  @Override
  public void onError(AsyncEvent event) throws IOException {
    Logger.getLogger(HelloAsyncListener.class.getName()).log(Level.SEVERE, null, event.getThrowable());
    event.getAsyncContext().complete();
  }

  @Override
  public void onStartAsync(AsyncEvent event) throws IOException {
    ServletResponse response = event.getAsyncContext().getResponse();
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
  }
}
