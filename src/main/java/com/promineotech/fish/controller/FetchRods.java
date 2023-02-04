package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;
import com.promineotech.fish.service.FetchRodsService;

@RestController
public class FetchRods implements FetchRodsController {
  
  @Autowired
  FetchRodsService fetchRodsService;
  
  @Override
  public List<Rod> fetchRod(RodAction fetch_rods) {
    return fetchRodsService.fetchRod(fetch_rods);
  }

}
