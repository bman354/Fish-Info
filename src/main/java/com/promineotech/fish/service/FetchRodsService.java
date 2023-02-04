package com.promineotech.fish.service;

import java.util.List;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;

public interface FetchRodsService {
  List<Rod> fetchRod(RodAction fetch_rods);
}
