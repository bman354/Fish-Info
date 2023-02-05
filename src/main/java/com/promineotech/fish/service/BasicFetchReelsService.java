package com.promineotech.fish.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fish.dao.FetchReelsDao;
import com.promineotech.fish.entities.Reel;

@Service
public class BasicFetchReelsService implements FetchReelsService {
  
  @Autowired
  FetchReelsDao fetchReelsDao;
  
  private final Logger Logger = LoggerFactory.getLogger(BasicFetchReelsService.class);

  @Override
  public List<Reel> FetchReels(String reel_power) {
    Logger.info("Fetch Reels called with reel_power = {}", reel_power);
    List<Reel> reels = fetchReelsDao.fetchReels(reel_power);
    return reels;
  }

}
