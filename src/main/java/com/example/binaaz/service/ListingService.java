package com.example.binaaz.service;

import com.example.binaaz.dto.ListingDTO;
import java.util.List;

public interface ListingService {
    List<ListingDTO> getAllListings();
    ListingDTO getListingById(Long id);
    ListingDTO createListing(ListingDTO listingDTO);
    ListingDTO updateListing(Long id, ListingDTO listingDTO);
    void deleteListing(Long id);
}
