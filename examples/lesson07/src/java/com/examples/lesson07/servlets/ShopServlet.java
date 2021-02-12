package com.examples.lesson07.servlets;

import com.examples.lesson07.model.Product;
import com.examples.lesson07.model.ProductCategory;
import com.examples.lesson07.model.ShoppingCart;
import com.examples.lesson07.services.ProductServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

  @Inject
  private ProductServices productServices;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    ShoppingCart shoppingCart = getShoppingCart(session);

    addOrRemoveItems(shoppingCart, request);

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Shop</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Shop List</h1>");

    out.println("<table>");
    out.println("<thead>");
    out.println("<tr>");
    out.println("<th>+</th>");
    out.println("<th>-</th>");
    out.println("<th>Product</th>");
    out.println("<th>Price</th>");
    out.println("<th>Qty</th>");
    out.println("<th>Total</th>");
    out.println("</tr>");
    out.println("</thead>");

    out.println("<tbody>");
    List<ProductCategory> allProductsByCategory = productServices.getAllProductsByCategory();
    for (ProductCategory category : allProductsByCategory) {
      out.println("<tr>");
      out.println("<td colspan=\"6\">" + category.getName() + "</td>");
      out.println("</tr>");
      for (Product product : category.getProducts()) {
        out.println("<tr>");
        out.println("<td>[<a href=\"ShopServlet?action=add&productId=" + product.getId() + "\">+</a>]</td>");
        out.println("<td>[<a href=\"ShopServlet?action=remove&productId=" + product.getId() + "\">-</a>]</td>");
        out.println("<td>" + product.getName() + "</td>");
        out.println("<td>" + product.getPrice() + "</td>");
        int quantity = shoppingCart.getQuantity(product.getId());
        out.println("<td>" + quantity + "</td>");
        double totalPrice = product.getPrice() * quantity;
        out.println("<td>" + totalPrice + "</td>");
        out.println("</tr>");
      }
    }
    out.println("</tbody>");
    out.println("</table>");
    out.println("<br>");
    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
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
}
