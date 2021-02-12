package com.examples.lesson04;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart.do"})
public class AddToCartServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String requestItem = request.getParameter("item");
    HttpSession session = request.getSession();
    Map<String, ShopItem> shoppingCart = (Map<String, ShopItem>) session.getAttribute("shoppingCart");
    if (shoppingCart == null) {
      shoppingCart = new HashMap<String, ShopItem>();
      session.setAttribute("shoppingCart", shoppingCart);
    }
    ShopItem item = shoppingCart.get(requestItem);
    if (item == null) {
      item = new ShopItem();
      item.setName(requestItem);
      shoppingCart.put(requestItem, item);
    }
    item.setQuantity(item.getQuantity() + 1);
    response.sendRedirect("viewShoppingCart");
  }
}
