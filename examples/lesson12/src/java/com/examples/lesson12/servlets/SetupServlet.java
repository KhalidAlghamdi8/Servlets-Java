package com.examples.lesson12.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SetupServlet", urlPatterns = {"/Setup"})
public class SetupServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    final String action = request.getParameter("action");
    if ("setup".equals(action)) {
      request.getRequestDispatcher("/setup/setupConfirm.jsp").forward(request, response);
    }
    if ("setup-confirm".equals(action)) {
      if (setup(request)) {
        getServletContext().setAttribute("initialized", true);
        request.getRequestDispatcher("/setup/setupComplete.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("/setup/setupError.jsp").forward(request, response);
      }
    }
    if ("skip".equals(action)) {
      getServletContext().setAttribute("initialized", true);
      request.getRequestDispatcher("/index.html").forward(request, response);
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private boolean setup(HttpServletRequest request) {
    try {
      new com.examples.lesson12.services.setup.Setup().setupJDNI();
      return true;
    } catch (Exception e) {
      request.setAttribute("error", e);
      StringWriter writer = new StringWriter();
      e.printStackTrace(new PrintWriter(writer));
      request.setAttribute("stackTrace", writer.toString());
      return false;
    }
  }
}
