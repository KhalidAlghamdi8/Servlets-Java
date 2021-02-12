package com.examples.lesson10.servlets.workers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

public class HelloAsyncWorker implements Runnable {

  private final AsyncContext asyncContext;

  public HelloAsyncWorker(AsyncContext asyncContext) {
    this.asyncContext = asyncContext;
  }

  @Override
  public void run() {
    try {
      //wait 2 seconds to process the request/response
      Thread.sleep(2000);
    } catch (InterruptedException ex) {
      Logger.getLogger(HelloAsyncWorker.class.getName()).log(Level.SEVERE, null, ex);
    }

    HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();

    try {
      PrintWriter out = response.getWriter();
      out.println(" World ");
      out.close();
    } catch (IOException ex) {
      Logger.getLogger(HelloAsyncWorker.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      asyncContext.complete();
    }
  }
}
