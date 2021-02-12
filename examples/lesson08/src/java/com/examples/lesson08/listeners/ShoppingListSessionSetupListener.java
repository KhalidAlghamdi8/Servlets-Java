package com.examples.lesson08.listeners;

import com.examples.lesson08.model.ShopItem;
import com.examples.lesson08.model.ShopList;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ShoppingListSessionSetupListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    ShopList shopList = new ShopList();
    shopList.add(createItem("Apple", "food"));
    shopList.add(createItem("Tomatoes", "food"));
    shopList.add(createItem("Radio", "electronics"));
    shopList.add(createItem("Flashlight", "electronics"));
    shopList.add(createItem("Mop", "cleaning"));
    shopList.add(createItem("Broom", "cleaning"));
    shopList.add(createItem("Screwdriver", "misc"));
    shopList.add(createItem("Light bulb", "misc"));
    shopList.add(createItem("Duct tape", "misc"));
    se.getSession().setAttribute("shopList", shopList);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
  }

  private ShopItem createItem(String name, String cat) {
    final ShopItem shopItem = new ShopItem();
    shopItem.setCategory(cat);
    shopItem.setName(name);
    shopItem.add();
    return shopItem;
  }
}
