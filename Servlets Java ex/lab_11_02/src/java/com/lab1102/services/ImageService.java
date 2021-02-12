package com.lab1102.services;

import com.lab1102.model.Image;

public interface ImageService {

  Image findImageById(int imageId);

  Image addImage(Image image);
}
