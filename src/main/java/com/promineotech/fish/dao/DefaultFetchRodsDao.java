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
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;
import com.promineotech.fish.entities.RodTipAction;


@Service
@Component
public class DefaultFetchRodsDao implements FetchRodsDao {
  private final Logger Logger = LoggerFactory.getLogger(FetchSpeciesDao.class);
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public List<Rod> fetchRods(RodAction rodAction) {
    Logger.info("DAO: speciesName={}", rodAction.toString());
    
    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM rods "
    + "WHERE rod_action = \""
    + rodAction.toString() + "\"";
    //@formatter:on 
    
    List<Rod> rods = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Rod mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Rod.builder()
            .rod_pk(rs.getInt("rod_pk"))
            .rod_id(rs.getString("rod_id"))
            .rodAction(RodAction.valueOf(rs.getString("rod_action")))
            .rodTipAction(RodTipAction.valueOf(rs.getString("rod_tip_action")))
            .rodLengthInch(rs.getInt("rod_length_inch"))
            .build();
      }
      
    });

    return rods;
  }
  @Override
  public Rod fetchRods(int rod_pk) {
    Logger.info("DAO: rod_pk={}", rod_pk);
    
    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM rods "
    + "WHERE rod_pk = "
    + rod_pk;
    //@formatter:on 
    
    List<Rod> rods = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Rod mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Rod.builder()
            .rod_pk(rs.getInt("rod_pk"))
            .rod_id(rs.getString("rod_id"))
            .rodAction(RodAction.valueOf(rs.getString("rod_action")))
            .rodTipAction(RodTipAction.valueOf(rs.getString("rod_tip_action")))
            .rodLengthInch(rs.getInt("rod_length_inch"))
            .build();
      }
      
    });

    return rods.get(0);
  }
}
