package com.promineotech.fish.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.promineotech.fish.entities.Bait;

@Service
public class BasicBaitsService implements BaitsService {
  
  
  private final Logger Logger = LoggerFactory.getLogger(BasicFetchSpeciesService.class);
  
  @Override
  public Bait createBait(String bait_name, Boolean isNatural) {
    Logger.info("Create Bait called with bait_name = {} and isNatural = {}", bait_name, isNatural);
    return null;
  }

  @Override
  public List<Bait> fetchBaits(String bait_name, Boolean isNatural) {
    Logger.info("Fetch Baits called with bait_name = {} and isNatural = {}", bait_name, isNatural);
    return null;
  }

  @Override
  public Bait updateBait(String oldName, Boolean oldIsNatural, String newName, Boolean newIsNatural) {
    Logger.info("Update Bait called with old_species_name = {}, old_isNatural = {}, new_bait_name = {}, new_bait_isNatural = {}", oldName, oldIsNatural, newName, newIsNatural);
    return null;
  }

  @Override
  public Bait deleteBait(String bait_name) {
    Logger.info("Delete Bait called with bait_name = {}", bait_name);
    return null;
  }

}
