package com.promineotech.fish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.entities.Bait;
import com.promineotech.fish.service.BaitsService;

@RestController
public class CreateBaits implements CreateBaitsController {
  
  @Autowired
  BaitsService baitsService;
  
  @Override
  public Bait createBait(String create_bait_name, Boolean create_bait_isNatural) {
    return baitsService.createBait(create_bait_name, create_bait_isNatural);
  }
}
