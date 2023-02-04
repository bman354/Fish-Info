package com.promineotech.fish.service;

import java.util.List;
import com.promineotech.fish.entities.Species;

public interface FetchSpeciesService {
  List<Species> fetchSpecies(String species_name);
}
