package com.promineotech.fish.service;

import java.util.List;
import com.promineotech.fish.entities.Reel;

public interface FetchReelsService {
  List<Reel> FetchReels(String reel_power);
}
