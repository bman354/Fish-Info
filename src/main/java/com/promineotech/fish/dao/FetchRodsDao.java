package com.promineotech.fish.dao;

import java.util.List;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;

public interface FetchRodsDao {
/**
 * 
 * @param RodAction rodAction
 * @return List of Rods
 */
  List<Rod> fetchRods(RodAction rodAction);

  Rod fetchRods(int rod_pk);

}
