package com.lab1201.services;

import com.lab1201.model.Image;

public interface ImageService {

  Image findImageById(int imageId);

  Image addImage(Image image);
}
