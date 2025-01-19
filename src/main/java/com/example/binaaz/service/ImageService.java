package com.example.binaaz.service;

import com.example.binaaz.dto.ImageDTO;
import java.util.List;

public interface ImageService {
    List<ImageDTO> getAllImages();
    ImageDTO getImageById(Long id);
    ImageDTO createImage(ImageDTO imageDTO);
    ImageDTO updateImage(Long id, ImageDTO imageDTO);
    void deleteImage(Long id);
}
