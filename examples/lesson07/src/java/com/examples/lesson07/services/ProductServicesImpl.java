package com.examples.lesson07.services;

import com.examples.lesson07.model.Product;
import com.examples.lesson07.model.ProductCategory;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServicesImpl implements ProductServices {

  private int currId = 1;
  private List<ProductCategory> categories;

  public ProductServicesImpl() {
    categories = new ArrayList<ProductCategory>();
    categories.add(createElectronics());
    categories.add(createGroceries());
    categories.add(createComputing());
  }

  @Override
  public List<ProductCategory> getAllProductsByCategory() {
    return categories;
  }

  private ProductCategory createElectronics() {
    ProductCategory category = new ProductCategory("Electronics");
    category.getProducts().add(new Product(getId(), category, "Phone", 14.0));
    category.getProducts().add(new Product(getId(), category, "CellPhone", 50.0));
    category.getProducts().add(new Product(getId(), category, "Stereo", 150.0));
    return category;
  }

  private ProductCategory createGroceries() {
    ProductCategory category = new ProductCategory("Toys");
    category.getProducts().add(new Product(getId(), category, "Car", 7.0));
    category.getProducts().add(new Product(getId(), category, "Doll", 10.0));
    category.getProducts().add(new Product(getId(), category, "Bear", 15.0));
    return category;
  }

  private ProductCategory createComputing() {
    ProductCategory category = new ProductCategory("Computing");
    category.getProducts().add(new Product(getId(), category, "Laptop", 700.0));
    category.getProducts().add(new Product(getId(), category, "Desktop", 900.0));
    category.getProducts().add(new Product(getId(), category, "Tablet", 550.0));
    return category;
  }

  private int getId() {
    return currId++;
  }
}
