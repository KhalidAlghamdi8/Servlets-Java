package com.examples.lesson08.servlets;

import com.examples.lesson08.model.ShopItem;
import com.examples.lesson08.model.ShopList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShopListServlet", urlPatterns = {"/ShopListServlet"})
public class ShopListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.getRequestDispatcher("/shopListView.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession session = request.getSession();
    String action = request.getParameter("action");
    ShopList shopList = (ShopList) session.getAttribute("shopList");
    String message = null;
    ShopItem modifiedItem = null;
    if ("new".equals(action)) {
      modifiedItem = new ShopItem();
      modifiedItem.setName(request.getParameter("itemName"));
      modifiedItem.setCategory(request.getParameter("itemCategory"));
      modifiedItem.add();
      shopList.add(modifiedItem);
      message = "New item:";

    }
    if ("add".equals(action)) {
      int id = Integer.parseInt(request.getParameter("id"));
      modifiedItem = shopList.get(id);
      if (modifiedItem != null) {
        modifiedItem.add();
      }
      message = "More of this item!";
    }
    if ("remove".equals(action)) {
      int id = Integer.parseInt(request.getParameter("id"));
      modifiedItem = shopList.get(id);
      message = "Less of this item!";
      if (modifiedItem != null) {
        modifiedItem.remove();
        if (modifiedItem.getCount() <= 0) {
          shopList.remove(id);
          message = "Item removed";
        }
      }
    }
    if ("delete".equals(action)) {
      int id = Integer.parseInt(request.getParameter("id"));
      modifiedItem = shopList.remove(id);
      message = "Item removed";
    }
    request.setAttribute("message", message);
    request.setAttribute("modified-item", modifiedItem);
    doGet(request, response);
  }
}
