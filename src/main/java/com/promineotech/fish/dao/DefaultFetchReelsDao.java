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
import com.promineotech.fish.entities.LineType;
import com.promineotech.fish.entities.Reel;

@Service
@Component
public class DefaultFetchReelsDao implements FetchReelsDao {

  private final Logger Logger = LoggerFactory.getLogger(FetchReelsDao.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Reel> fetchReels(String reel_power) {
    Logger.info("DAO: reel_power={}", reel_power);

    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM reels "
    + "WHERE reel_power = "
    + reel_power;
    //@formatter:on 

    List<Reel> reels = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Reel mapRow(ResultSet rs, int rowNum) throws SQLException {

    //@formatter:off
    return Reel.builder()
        .reel_pk(rs.getInt("reel_pk"))
        .reel_name(rs.getString("reel_name"))
        .reel_power(rs.getString("reel_power"))
        .lineType(LineType.valueOf(rs.getString("line_type")))
        .lineWeight(rs.getInt("line_weight"))
        .build();
  //@formatter:on
      }

    });

    return reels;



  }

  public Reel fetchReels(int reel_pk) {
    Logger.info("DAO: reel_power={}", reel_pk);

    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM reels "
    + "WHERE reel_pk = "
    + reel_pk;
    //@formatter:on 

    List<Reel> reels = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Reel mapRow(ResultSet rs, int rowNum) throws SQLException {

    //@formatter:off
    return Reel.builder()
        .reel_pk(rs.getInt("reel_pk"))
        .reel_name(rs.getString("reel_name"))
        .reel_power(rs.getString("reel_power"))
        .lineType(LineType.valueOf(rs.getString("line_type")))
        .lineWeight(rs.getInt("line_weight"))
        .build();
  //@formatter:on
      }

    });

    return reels.get(0);


  }
}
