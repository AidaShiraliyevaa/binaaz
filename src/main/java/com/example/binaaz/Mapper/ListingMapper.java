package com.example.binaaz.Mapper;

import com.example.binaaz.dto.ListingDTO;
import com.example.binaaz.entity.Listing;
import org.springframework.stereotype.Component;

@Component
public class ListingMapper {
    public Listing toEntity(ListingDTO dto) {
        return Listing.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }

    public ListingDTO toDTO(Listing listing) {
        return ListingDTO.builder()
                .id(listing.getId())
                .title(listing.getTitle())
                .description(listing.getDescription())
                .price(listing.getPrice())
                .categoryId(listing.getCategory().getId())
                .userId(listing.getUser().getId())
                .build();
    }
}
