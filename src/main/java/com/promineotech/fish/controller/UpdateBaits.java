package com.promineotech.fish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.service.BaitsService;

@RestController
public class UpdateBaits implements UpdateBaitsController {
  
  @Autowired
  BaitsService baitsService;
  
  @Override
  public void updateBait(String old_bait_name, Boolean old_bait_isNatural, String new_bait_name, Boolean new_bait_isNatural) {
    baitsService.updateBait(old_bait_name, old_bait_isNatural, new_bait_name, new_bait_isNatural);
  }

}
