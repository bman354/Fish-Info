package com.promineotech.fish.dao;

import java.util.List;
import com.promineotech.fish.entities.Bait;

public interface BaitsDao {
/**
 * 
 * @param String bait_name
 * @param Boolean isNatural
 * @return Returns a new bait
 */
  Bait createBait(String bait_name, Boolean isNatural);
/**
 * 
 * @param String bait_name
 * @param Boolean isNatural
 * @return Returns a list of Baits
 */
  List<Bait> fetchBaits(String bait_name, Boolean isNatural);
/**
 * 
 * @param String oldName
 * @param Boolean oldIsNatural
 * @param String newName
 * @param String newIsNatural
 */
  void updateBait(String oldName, Boolean oldIsNatural, String newName, Boolean newIsNatural);
/**
 * 
 * @param String bait_name
 */
  void deleteBait(String bait_name);
  /**
   * 
   * @param bait_pk
   * @return Returns a list of baits based on the primary key value
   */
  Bait fetchBaits(int bait_pk);



}
