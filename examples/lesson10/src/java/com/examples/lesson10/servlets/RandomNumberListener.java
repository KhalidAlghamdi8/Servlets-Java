package com.examples.lesson10.servlets;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

class RandomNumberListener implements AsyncListener {

  private final RandomNumberWorker randomNumberWorker;

  RandomNumberListener(RandomNumberWorker randomNumberWorker) {
    this.randomNumberWorker = randomNumberWorker;
  }

  @Override
  public void onComplete(AsyncEvent event) throws IOException {
    randomNumberWorker.remove(event.getAsyncContext());
  }

  @Override
  public void onTimeout(AsyncEvent event) throws IOException {
    randomNumberWorker.remove(event.getAsyncContext());
    event.getAsyncContext().complete();
  }

  @Override
  public void onError(AsyncEvent event) throws IOException {
    randomNumberWorker.remove(event.getAsyncContext());
    event.getAsyncContext().complete();
  }

  @Override
  public void onStartAsync(AsyncEvent event) throws IOException {
  }
}
