package com.example.binaaz.ServiceImplementation;

import com.example.binaaz.dto.ListingDTO;
import com.example.binaaz.entity.Listing;
import com.example.binaaz.Mapper.ListingMapper;
import com.example.binaaz.repository.ListingRepository;
import com.example.binaaz.service.ListingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;

    public ListingServiceImpl(ListingRepository listingRepository, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    @Override
    public List<ListingDTO> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(listingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListingDTO getListingById(Long id) {
        Listing listing = listingRepository.findById(id).orElseThrow(() -> new RuntimeException("Listing not found"));
        return listingMapper.toDTO(listing);
    }

    @Override
    public ListingDTO createListing(ListingDTO listingDTO) {
        Listing listing = listingMapper.toEntity(listingDTO);
        Listing savedListing = listingRepository.save(listing);
        return listingMapper.toDTO(savedListing);
    }

    @Override
    public ListingDTO updateListing(Long id, ListingDTO listingDTO) {
        Listing existingListing = listingRepository.findById(id).orElseThrow(() -> new RuntimeException("Listing not found"));

        existingListing.setTitle(listingDTO.getTitle());
        existingListing.setDescription(listingDTO.getDescription());
        existingListing.setPrice(listingDTO.getPrice());

        Listing updatedListing = listingRepository.save(existingListing);
        return listingMapper.toDTO(updatedListing);
    }

    @Override
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}
