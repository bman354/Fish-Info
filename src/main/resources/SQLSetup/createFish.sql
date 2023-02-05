DROP TABLE IF EXISTS baits_species;
DROP TABLE IF EXISTS baits;
DROP TABLE IF EXISTS species;
DROP TABLE IF EXISTS rods;
DROP TABLE IF EXISTS reels;



CREATE TABLE IF NOT EXISTS rods(
  rod_pk INT AUTO_INCREMENT NOT NULL,
  rod_id VARCHAR(32),
  rod_action ENUM('LIGHT', 'MEDIUM', 'HEAVY') NOT NULL,
  rod_tip_action ENUM('LIGHT', 'MEDIUM', 'HEAVY') NOT NULL,
  rod_length_inch INT NOT NULL,
  PRIMARY KEY (rod_pk)
);

CREATE TABLE IF NOT EXISTS reels(
  reel_pk INT AUTO_INCREMENT NOT NULL,
  reel_name varchar(32),
  reel_power varchar(32),
  line_type ENUM('BRAID','MONOFILIMENT','FLUOROCARBON'),
  line_weight INT,
  PRIMARY KEY (reel_pk)
);

CREATE TABLE IF NOT EXISTS baits(
  bait_pk INT AUTO_INCREMENT NOT NULL,
  bait_id VARCHAR(64) NOT NULL,
  is_natural BOOL,
  PRIMARY KEY (bait_pk)
);

CREATE TABLE IF NOT EXISTS species(
  species_pk INT AUTO_INCREMENT NOT NULL,
  rod_fk INT,
  reel_fk INT,
  species_id VARCHAR(32) NOT NULL,
  habitat ENUM('MANGROVES', 'FLATS', 'REEFS', "DEEP_HOLES") NOT NULL,
  pro_tip text,
  PRIMARY KEY (species_pk),
  FOREIGN KEY (rod_fk) REFERENCES rods(rod_pk) ON DELETE CASCADE,
  FOREIGN KEY (reel_fk) REFERENCES reels(reel_pk) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS baits_species(
  bait_species_pk INT AUTO_INCREMENT NOT NULL,
  species_fk INT,
  bait_fk INT,
  PRIMARY KEY (bait_species_pk),
  FOREIGN KEY (species_fk) REFERENCES species(species_pk) ON DELETE CASCADE,
  FOREIGN KEY (bait_fk) REFERENCES baits(bait_pk) ON DELETE CASCADE
);







