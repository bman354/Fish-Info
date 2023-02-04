package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.entities.Species;
import com.promineotech.fish.service.FetchSpeciesService;

@RestController
public class FetchSpecies implements FetchSpeciesController {

  @Autowired
  FetchSpeciesService fetchSpeciesService;
  
  @Override
  public List<Species> fetchSpecies(String species) {
    return fetchSpeciesService.fetchSpecies(species);
  }

}
