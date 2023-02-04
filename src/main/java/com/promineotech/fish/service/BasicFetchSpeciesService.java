package com.promineotech.fish.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.promineotech.fish.entities.Species;

@Service
public class BasicFetchSpeciesService implements FetchSpeciesService {

  private final Logger Logger = LoggerFactory.getLogger(BasicFetchSpeciesService.class);
  @Override
  public List<Species> fetchSpecies(String species_name) {
    Logger.info("Fetch Species called with species_name = {}", species_name);
    return null;
  }

}
