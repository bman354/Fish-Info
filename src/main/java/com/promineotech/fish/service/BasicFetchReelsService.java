package com.promineotech.fish.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.promineotech.fish.entities.Reel;

@Service
public class BasicFetchReelsService implements FetchReelsService {

  private final Logger Logger = LoggerFactory.getLogger(BasicFetchReelsService.class);
  @Override
  public List<Reel> FetchReels(String reel_power) {
    Logger.info("Fetch Species called with species_name = {}", reel_power);
    return null;
  }

}
