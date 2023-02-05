package com.promineotech.fish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.service.BaitsService;

@RestController
public class DeleteBaits implements DeleteBaitsController {
  
  @Autowired
  BaitsService baitsService;
  
  @Override
  public void deleteBait(String delete_bait) {
    baitsService.deleteBait(delete_bait);
  }

}
