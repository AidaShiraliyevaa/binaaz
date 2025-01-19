package com.example.binaaz.Mapper;

import com.example.binaaz.dto.ImageDTO;
import com.example.binaaz.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
    public Image toEntity(ImageDTO dto) {
        return Image.builder()
                .id(dto.getId())
                .url(dto.getUrl())
                .build();
    }

    public ImageDTO toDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .url(image.getUrl())
                .listingId(image.getListing().getId())
                .build();
    }
}
