package com.examples.lesson07.servlets;

import com.examples.lesson07.model.ProductCategory;
import com.examples.lesson07.model.ShoppingCart;
import com.examples.lesson07.services.ProductServices;
import com.examples.lesson07.view.ProductCategoryView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShopServletController", urlPatterns = {"/Shop"})
public class ShopServletController extends HttpServlet {

  @Inject
  private ProductServices productServices;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    ShoppingCart shoppingCart = getShoppingCart(request.getSession());

    addOrRemoveItems(shoppingCart, request);

    List<ProductCategory> allProductsByCategory = productServices.getAllProductsByCategory();
    List<ProductCategoryView> categoriesView = new ArrayList<ProductCategoryView>();
    for (ProductCategory category : allProductsByCategory) {
      categoriesView.add(new ProductCategoryView(category, shoppingCart));
    }
    request.setAttribute("categories", categoriesView);
    request.getRequestDispatcher("shopView.jsp").forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  private ShoppingCart getShoppingCart(HttpSession session) {
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if (shoppingCart == null) {
      shoppingCart = new ShoppingCart();
      session.setAttribute("shoppingCart", shoppingCart);
    }
    return shoppingCart;
  }

  private void addOrRemoveItems(ShoppingCart shoppingCart, HttpServletRequest request) {
    String action = request.getParameter("action");
    try {
      int productId = Integer.parseInt(request.getParameter("productId"));
      if ("add".equals(action)) {
        shoppingCart.add(productId);
      }
      if ("remove".equals(action)) {
        shoppingCart.remove(productId);
      }
    } catch (Exception e) {
    }
  }
}
