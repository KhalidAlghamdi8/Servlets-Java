package com.examples.lesson10.servlets;

import com.examples.lesson10.servlets.listeners.HelloAsyncListener;
import com.examples.lesson10.servlets.workers.HelloAsyncWorker;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAsyncServlet", urlPatterns = {"/HelloAsyncServlet"}, asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

  private ExecutorService executorService = Executors.newCachedThreadPool();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AsyncContext asyncContext = request.startAsync(request, response);
    asyncContext.addListener(new HelloAsyncListener());
    executorService.execute(new HelloAsyncWorker(asyncContext));
  }

  @Override
  public void destroy() {
    executorService.shutdownNow();
  }
}
