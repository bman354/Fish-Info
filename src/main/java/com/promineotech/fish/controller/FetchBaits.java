package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.entities.Bait;
import com.promineotech.fish.service.BaitsService;

@RestController
public class FetchBaits implements FetchBaitsController {
  
  @Autowired
  BaitsService baitsService;
  
  @Override
  public List<Bait> fetchBaits(String fetch_baits, Boolean fetch_baits_isNatural) {
    return baitsService.fetchBaits(fetch_baits, fetch_baits_isNatural);
  }

}
