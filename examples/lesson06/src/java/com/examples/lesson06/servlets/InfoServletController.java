package com.examples.lesson06.servlets;

import com.examples.lesson06.model.InfoBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InfoServletController", urlPatterns = {"/infoController"})
public class InfoServletController extends HttpServlet {

  private static final String SERVER_NAME = "TEST SERVER";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String serverName = SERVER_NAME;
    String serverMemory = formatBytes(Runtime.getRuntime().maxMemory());
    String serverFreeMemory = formatBytes(Runtime.getRuntime().freeMemory());
    String serverCores = Integer.toString(Runtime.getRuntime().availableProcessors());
    String serverTime = new SimpleDateFormat().format(new Date());

    InfoBean infoBean = new InfoBean();
    infoBean.setServerCores(serverCores);
    infoBean.setServerFreeMemory(serverFreeMemory);
    infoBean.setServerMemory(serverMemory);
    infoBean.setServerName(serverName);
    infoBean.setServerTime(serverTime);

    request.setAttribute("infoBean", infoBean);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/infoServletView.jsp");
    requestDispatcher.forward(request, response);
  }

  private String formatBytes(long bytes) {
    if (bytes < 1024) {
      return bytes + "B";
    }
    if (bytes < 1024 * 1024) {
      return (bytes / 1024) + "KB";
    }
    return (bytes / (1024 * 1024)) + "MB";
  }
}
