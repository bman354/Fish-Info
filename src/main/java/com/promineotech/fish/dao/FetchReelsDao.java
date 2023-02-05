package com.promineotech.fish.dao;

import java.util.List;
import com.promineotech.fish.entities.Reel;

public interface FetchReelsDao {
/**
 * 
 * @param String reel_power
 * @return List of Reels
 */
  List<Reel> fetchReels(String reel_power);
  
  Reel fetchReels(int reel_pk);
}
