package com.examples.lesson10.servlets;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;

class RandomNumberWorker implements Runnable {

  private final ExecutorService executorService;
  private final List<AsyncContext> contexts;
  long runCount = 0;

  RandomNumberWorker(ExecutorService executorService) {
    this.executorService = executorService;
    contexts = new LinkedList<AsyncContext>();
  }

  @Override
  public void run() {
    try {
      doTask();
    } catch (Exception ex) {
      Logger.getLogger(RandomNumberWorker.class.getName()).log(Level.SEVERE, null, ex);
    }
    //re-run this task
    executorService.execute(this);
  }

  private void doTask() throws Exception {
    runCount++;
    //wait one second.
    Thread.sleep(1000);

    int number = (int) (Math.random() * 100);

    List<AsyncContext> contextsCopy;

    synchronized (contexts) {
      contextsCopy = new ArrayList<AsyncContext>(contexts);
    }
    int count = contextsCopy.size();
    for (AsyncContext context : contextsCopy) {
      try {
        PrintWriter writer = context.getResponse().getWriter();
        writer.println(String.format("<b>Your number:%03d</b> ", number));
        writer.println(String.format("Debug: clients=%d,runs=%d,instance=%s", count, runCount, Integer.toHexString(hashCode())));
        writer.close();
        context.complete();
      } catch (Exception ex) {
        Logger.getLogger(RandomNumberWorker.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  void add(AsyncContext asyncContext) {
    synchronized (contexts) {
      contexts.add(asyncContext);
    }
  }

  void remove(AsyncContext asyncContext) {
    synchronized (contexts) {
      contexts.remove(asyncContext);
    }
  }
}
