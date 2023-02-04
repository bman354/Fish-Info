package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.fish.entities.Reel;
import com.promineotech.fish.service.FetchReelsService;

@RestController
public class FetchReels implements FetchReelsController {
  
  @Autowired
  FetchReelsService fetchReelsService;
  @Override
  public List<Reel> fetchReels(String fetch_reel) {
    return fetchReelsService.FetchReels(fetch_reel);
  }

}
