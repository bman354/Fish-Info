package com.promineotech.fish.dao;

import java.util.List;
import com.promineotech.fish.entities.Species;

public interface FetchSpeciesDao {
  /**
   * 
   * @param String speciesName
   * @return list of species that matches speciesName
   */
  List<Species> FetchSpecies(String speciesName);
}
