package com.examples.lesson10.servlets.workers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;

public class CountToTenAsyncWorker implements Runnable {

  private final AsyncContext asyncContext;

  public CountToTenAsyncWorker(AsyncContext asyncContext) {
    this.asyncContext = asyncContext;
  }

  @Override
  public void run() {
    try {
      for (int i = 1; i < 11; i++) {
        System.out.println("Counting: " + i);
        PrintWriter writer = asyncContext.getResponse().getWriter();
        writer.write(Integer.toString(i) + "\n");
        writer.flush();
        Thread.sleep(1000);
      }
    } catch (IOException ex) {
      Logger.getLogger(CountToTenAsyncWorker.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InterruptedException ex) {
      Logger.getLogger(CountToTenAsyncWorker.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      asyncContext.complete();
    }
  }
}
