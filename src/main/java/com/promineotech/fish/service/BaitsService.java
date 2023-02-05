package com.promineotech.fish.service;

import java.util.List;
import com.promineotech.fish.entities.Bait;

public interface BaitsService {
  Bait createBait(String bait_name, Boolean isNatural);
  
  List<Bait> fetchBaits(String bait_name, Boolean fetch_baits_isNatural);
  
  void updateBait(String oldName, Boolean oldIsNatural, String newName, Boolean newIsNatural);
  
  void deleteBait(String bait_name);
}
