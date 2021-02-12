package com.lab1001.services.impl;

import com.lab1001.model.Image;
import com.lab1001.services.ImageService;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImageServiceMem implements ImageService {

  private int currentImageId;
  private Map<Integer, Image> images;

  public ImageServiceMem() {
  }

  @PostConstruct
  public void setup() {
    images = new ConcurrentHashMap<Integer, Image>();
    currentImageId = 2000;
    addImage(getPhoto("images/AntiquePhoneStand.jpg"), "image/jpeg");
    addImage(getPhoto("images/Doll.jpg"), "image/jpeg");
    addImage(getPhoto("images/AntiqueCoffeeGrinder.jpg"), "image/jpeg");
    addImage(getPhoto("images/SaltPepperShakers.jpg"), "image/jpeg");
    addImage(getPhoto("images/PolarBear.jpg"), "image/jpeg");
    addImage(getPhoto("images/Backpack.jpg"), "image/jpeg");
    addImage(getPhoto("images/HorseSculpture.jpg"), "image/jpeg");
  }

  @Override
  public Image findImageById(int imageId) {
    return images.get(imageId);
  }

  @Override
  public Image addImage(Image image) {
    int id = currentImageId;
    currentImageId++;
    image.setImageId(id);
    images.put(id, image);
    return image;
  }

  private byte[] getPhoto(String filePath) {
    InputStream inputStream = null;
    ByteArrayOutputStream outputStream = null;
    try {
      inputStream = getClass().getResourceAsStream(filePath);
      outputStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int read;
      while ((read = inputStream.read(buffer, 0, buffer.length)) >= 0) {
        outputStream.write(buffer, 0, read);
      }
      outputStream.flush();
      return outputStream.toByteArray();
    } catch (Exception i) {
      System.err.println("Exception loading photo:" + filePath + " : " + i.getClass().getName() + " Message: " + i.getMessage());
    } finally {
      try {
        inputStream.close();
      } catch (Exception e) {
        System.err.println("Error closing stream" + e);
      }
      try {
        outputStream.close();
      } catch (Exception e) {
        System.err.println("Error closing stream" + e);
      }
    }
    return null;
  }

  public Map<?, ? extends Object> getImages() {
    return images;
  }

  private void addImage(byte[] data, String contentType) {
    addImage(new Image(0, data, contentType));
  }
}
