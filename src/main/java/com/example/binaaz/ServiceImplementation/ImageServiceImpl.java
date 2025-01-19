package com.example.binaaz.ServiceImplementation;

import com.example.binaaz.dto.ImageDTO;
import com.example.binaaz.entity.Image;
import com.example.binaaz.Mapper.ImageMapper;
import com.example.binaaz.repository.ImageRepository;
import com.example.binaaz.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    @Override
    public List<ImageDTO> getAllImages() {
        return imageRepository.findAll()
                .stream()
                .map(imageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ImageDTO getImageById(Long id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
        return imageMapper.toDTO(image);
    }

    @Override
    public ImageDTO createImage(ImageDTO imageDTO) {
        Image image = imageMapper.toEntity(imageDTO);
        Image savedImage = imageRepository.save(image);
        return imageMapper.toDTO(savedImage);
    }

    @Override
    public ImageDTO updateImage(Long id, ImageDTO imageDTO) {
        Image existingImage = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));

        existingImage.setUrl(imageDTO.getUrl());

        Image updatedImage = imageRepository.save(existingImage);
        return imageMapper.toDTO(updatedImage);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}

