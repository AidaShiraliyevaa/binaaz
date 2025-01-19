package com.example.binaaz.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListingDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private Long userId;
}
