package com.promineotech.fish.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fish.dao.FetchRodsDao;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;

@Service
public class BasicFetchRodsService implements FetchRodsService {

  @Autowired
  FetchRodsDao fetchRodsDao;

  private final Logger Logger = LoggerFactory.getLogger(BasicFetchRodsService.class);

  @Override
  public List<Rod> fetchRod(RodAction rodAction) {
    Logger.info("Fetch Rod called with rodAction = {}", rodAction.toString());
    List<Rod> rods = fetchRodsDao.fetchRods(rodAction);
    return rods;
  }

}
