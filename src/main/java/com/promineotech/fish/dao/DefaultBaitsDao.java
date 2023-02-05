package com.promineotech.fish.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.fish.entities.Bait;


@Service
@Component
public class DefaultBaitsDao implements BaitsDao {

  private final Logger Logger = LoggerFactory.getLogger(BaitsDao.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Bait createBait(String bait_name, Boolean isNatural) {
    Logger.info("DAO: bait_name={}, isNatural = {}", bait_name, isNatural);
    //TODO add new bait to applicable species through baits_species table
    int isNaturalValue;
    
    if(isNatural) {
      isNaturalValue = 1;
    } else {
      isNaturalValue = 0;
    }
    
    //@formatter:off
    String sql = ""
    + "INSERT INTO baits(bait_id, is_natural) VALUES(\"" + bait_name + "\", " + isNatural+")";
    
    
    Logger.info("DAO: executing {}", sql);
    jdbcTemplate.execute(sql);
    
    //@formatter:off
    String sqlQuery = ""
    + "SELECT * "
    + "FROM baits "
    + "WHERE bait_id = \""
    + bait_name + "\" AND is_natural = " +
    + isNaturalValue;
    //@formatter:on
    
    //@formatter:on     

    List<Bait> baits = jdbcTemplate.query(sqlQuery, new RowMapper<>() {
      @Override
      public Bait mapRow(ResultSet rs, int row) throws SQLException {
        //@formatter:off
        return Bait.builder()
            .bait_pk(rs.getInt("bait_pk"))
            .bait_id(rs.getString("bait_id"))
            .isNatural(rs.getBoolean("is_natural"))
            .build();
      }
    });
  //@formatter:on
    Logger.info("DAO: returning bait = {}, create bait successful", baits.get(0).getBait_id());
    return baits.get(0);
  }

  @Override
  public List<Bait> fetchBaits(String bait_name, Boolean isNatural) {
    Logger.info("DAO: bait_name={}, isNatural = {}", bait_name, isNatural);
    
    int isNaturalValue;
    
    if(isNatural) {
      isNaturalValue = 1;
    } else {
      isNaturalValue = 0;
    }
    
    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM baits "
    + "WHERE bait_id = \""
    + bait_name + "\" AND is_natural = " +
    + isNaturalValue;
    //@formatter:on     

    List<Bait> baits = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Bait mapRow(ResultSet rs, int row) throws SQLException {
        //@formatter:off
        return Bait.builder()
            .bait_pk(rs.getInt("bait_pk"))
            .bait_id(rs.getString("bait_id"))
            .isNatural(rs.getBoolean("is_natural"))
            .build();
      }
    });
  //@formatter:on
    return baits;
  }
  
  
  //returns a single bait from a primary key
  @Override
  public Bait fetchBaits(int bait_pk) {
    Logger.info("DAO: bait_pk={}", bait_pk);
    
    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM baits "
    + "WHERE bait_pk = "
    + bait_pk;
    //@formatter:on     

    List<Bait> baits = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Bait mapRow(ResultSet rs, int row) throws SQLException {
        //@formatter:off
        return Bait.builder()
            .bait_pk(rs.getInt("bait_pk"))
            .bait_id(rs.getString("bait_id"))
            .isNatural(rs.getBoolean("is_natural"))
            .build();
      }
    });
  //@formatter:on
    return baits.get(0);
  }
  @Override
  public void updateBait(String oldName, Boolean oldIsNatural, String newName,
      Boolean newIsNatural) {
    Logger.info("DAO: updating bait = {} with is_natural = {}, replacing with bait_id = {}, is_natural = {}", oldName, oldIsNatural, newName, newIsNatural);
    
    
    int intNewIsNatural = turnBooleanIntoInt(newIsNatural);
    int intOldIsNatural = turnBooleanIntoInt(oldIsNatural);
    
    
    
    String sql = ""
        + "UPDATE baits "
        + "SET bait_id = '" + newName + "', "
        + "is_natural = '" + intNewIsNatural + "' "
        + "WHERE bait_id = '" + oldName + "' "
        + "AND is_natural = '" + intOldIsNatural + "'";
     Logger.info(sql);
     jdbcTemplate.execute(sql);
  }

  @Override
  public void deleteBait(String bait_name) {
    Logger.info("DAO: Deleting bait_id = {}", bait_name);
    
    String sql = ""
        + "DELETE FROM baits WHERE bait_id = '" + bait_name + "'";
    Logger.info(sql);
    jdbcTemplate.execute(sql);
  }
  
  
  
  //workaround for truncated double boolean sql error, converts boolean to int (1=true 0=false)
  private int turnBooleanIntoInt(Boolean bool) {
    if(bool) {
      return 1;
    } else {
      return 0;
    }
  }
}
