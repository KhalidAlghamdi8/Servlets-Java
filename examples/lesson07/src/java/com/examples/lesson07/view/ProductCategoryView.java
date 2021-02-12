package com.examples.lesson07.view;

import com.examples.lesson07.model.Product;
import com.examples.lesson07.model.ProductCategory;
import com.examples.lesson07.model.ShoppingCart;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryView {

  private final String name;
  private final List<ProductView> products;

  public ProductCategoryView(ProductCategory category, ShoppingCart shoppingCart) {
    this.name = category.getName();
    this.products = new ArrayList<ProductView>();
    for (Product product : category.getProducts()) {
      this.products.add(new ProductView(product, shoppingCart.getQuantity(product.getId())));
    }
  }

  public String getName() {
    return name;
  }

  public List<ProductView> getProducts() {
    return products;
  }
}
