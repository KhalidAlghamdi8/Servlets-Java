package com.lab1001.services;

import com.lab1001.model.Image;

public interface ImageService {

  Image findImageById(int imageId);

  Image addImage(Image image);
}
