package com.promineotech.fish.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.fish.entities.Bait;
import com.promineotech.fish.entities.Habitat;
import com.promineotech.fish.entities.Reel;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.Species;

@Service
@Component
public class DefaultFetchSpeciesDao implements FetchSpeciesDao {

  private final Logger Logger = LoggerFactory.getLogger(FetchSpeciesDao.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private FetchReelsDao fetchReelsDao;

  @Autowired
  private FetchRodsDao fetchRodsDao;

  @Autowired
  private BaitsDao baitsDao;

  @Override
  public List<Species> FetchSpecies(String speciesName) {

    Logger.info("DAO: speciesName={}", speciesName);

    //@formatter:off
    String sql = ""
    + "SELECT * "
    + "FROM species "
    + "WHERE species_id = \""
    + speciesName + "\"";
    //@formatter:on     

    List<Species> species = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Species mapRow(ResultSet rs, int row) throws SQLException {

        return Species.builder().species_id(rs.getString("species_id"))
            .habitat(Habitat.valueOf(rs.getString("habitat"))).rod(buildRod(rs.getInt("rod_fk")))
            .reel(buildReel(rs.getInt("rod_fk"))).pro_tip(rs.getString("pro_tip"))
            .baits(buildBaits(rs.getInt("species_pk"))).build();
      }
    });
    Logger.info(species.toString());
    return species;
  }

  private Rod buildRod(int rod_fk) {
    return fetchRodsDao.fetchRods(rod_fk);
  }

  private Reel buildReel(int reel_fk) {
    return fetchReelsDao.fetchReels(reel_fk);
  }

  private List<Bait> buildBaits(int species_pk) {
    // for all values in baits_species that have the same species key as the one we are looking for,
    // add an integer to the list of bait primary keys to retrieve
    //bait_species_pk stores the bait_fk values to retrieve
    String sql = "" + "SELECT * FROM baits_species WHERE species_fk = " + species_pk;

    List<Integer> bait_species_pk = jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Integer mapRow(ResultSet rs, int row) throws SQLException {

        return rs.getInt("bait_fk");
      }
    });
    
    List<Bait> baits = new LinkedList<>();
    bait_species_pk.forEach(id -> baits.add(baitsDao.fetchBaits(id)));

    return baits;
  }

}
