package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ViewShoppingCartServlet", urlPatterns = {"/viewShoppingCart"})
public class ViewShoppingCartServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Your shopping cart</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Shopping cart</h1>");

    HttpSession session = request.getSession();
    Map<String, ShopItem> shoppingCart = (Map<String, ShopItem>) session.getAttribute("shoppingCart");
    if (shoppingCart == null || shoppingCart.isEmpty()) {
      out.println("<h2>Your cart is empty.</h2>");
    } else {
      out.println("<ul>");
      for (ShopItem item : shoppingCart.values()) {
        out.println("<li>" + item.getQuantity() + "<b>: " + item.getName() + "</b></li>");

      }
      out.println("</ul>");
    }
    out.println("<a href=\"shop.html\">Go Back</a> ");
    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
