package com.examples.lesson06.servlets;

import com.examples.lesson06.services.InfoService;
import com.examples.lesson06.model.InfoBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InfoServletCdiController", urlPatterns = {"/infoCdiController"})
public class InfoServletCdiController extends HttpServlet {

  @Inject
  private InfoService infoService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    InfoBean infoBean = new InfoBean();
    infoBean.setServerCores(infoService.calculateServerCores());
    infoBean.setServerFreeMemory(infoService.calculateServerFreeMemory());
    infoBean.setServerMemory(infoService.calculateServerMemory());
    infoBean.setServerName(infoService.calculateServerName());
    infoBean.setServerTime(infoService.calculateServerTime());


    request.setAttribute("infoBean", infoBean);

    request.getRequestDispatcher("/infoServletView.jsp").forward(request, response);
  }
}
