package com.examples.lesson10.servlets;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RandomNumberServlet", urlPatterns = {"/RandomNumberServlet"}, asyncSupported = true)
public class RandomNumberServlet extends HttpServlet {

  private final ExecutorService executorService = Executors.newSingleThreadExecutor();
  private RandomNumberWorker randomNumbersWorker;

  @Override
  public void init() throws ServletException {
    randomNumbersWorker = new RandomNumberWorker(executorService);
    executorService.execute(randomNumbersWorker);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AsyncContext asyncContext = request.startAsync(request, response);
    randomNumbersWorker.add(asyncContext);
    asyncContext.addListener(new RandomNumberListener(randomNumbersWorker));
  }

  @Override
  public void destroy() {
    executorService.shutdownNow();
  }
}
