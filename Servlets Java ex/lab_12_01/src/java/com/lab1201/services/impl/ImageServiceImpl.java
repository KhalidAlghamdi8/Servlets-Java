package com.lab1201.services.impl;

import com.lab1201.model.Image;
import com.lab1201.services.ImageService;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImageServiceImpl implements ImageService {

  private static final Logger LOG = Logger.getLogger(ImageServiceImpl.class.getName());
  private int currentImageId;
  private final Map<Integer, Image> images;

  public ImageServiceImpl() {
    images = new HashMap<Integer, Image>();
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
}