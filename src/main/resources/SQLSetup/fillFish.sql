
-- Rods
INSERT INTO rods (rod_id, rod_action, rod_tip_action, rod_length_inch) VALUES ('The Tarpon Stick', 'HEAVY', 'MEDIUM', 96);
INSERT INTO rods (rod_id, rod_action, rod_tip_action, rod_length_inch) VALUES ('The All Arounder Rod', 'MEDIUM', 'MEDIUM', 84);
INSERT INTO rods (rod_id, rod_action, rod_tip_action, rod_length_inch) VALUES ('The Lightweight Rod', 'LIGHT', 'LIGHT', 84);

-- Reels
INSERT INTO reels (reel_name, reel_power, line_type, line_weight) VALUES('Large Marge', '6000', 'BRAID', 30);
INSERT INTO reels (reel_name, reel_power, line_type, line_weight) VALUES('All Around Reel', '3000', 'BRAID', 20);
INSERT INTO reels (reel_name, reel_power, line_type, line_weight) VALUES('Medium-Small', '2500', 'FLUOROCARBON', 15);
INSERT INTO reels (reel_name, reel_power, line_type, line_weight) VALUES('All Around Clear Water', '3000', 'MONOFILIMENT', 30);

-- Baits
INSERT INTO baits (bait_id, is_natural) VALUES('Small Live Crabs', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Large Live Shrimp', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Threadfin Herring', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Chunk Ladyfish', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('DOA Bait Buster', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Soft Plastic Swim Bait', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Medium Live Shrimp', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Live Pinfish', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Soft Plastic Shadtail on Jighead', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Size 10 Rapala XRap', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Frozen Shrimp', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Weedless Spoon', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Soft Paddle Tail', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Frozen Silversides', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Live Pigfish', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Frozen Clams', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Fish Bites', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Live White Bait', TRUE);
INSERT INTO baits (bait_id, is_natural) VALUES('Spoon', FALSE);
INSERT INTO baits (bait_id, is_natural) VALUES('Gotcha Tube', FALSE);

-- Species
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(1, 1, 'Tarpon', "DEEP_HOLES", 'Use a DOA bait buster or equivalent soft rigged swim bait with a bobber. Nobody is better at catching fish than Rodney B. Holder (Your rod holder)');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(2, 2, 'Snook', 'MANGROVES', 'If you fish from land, stick to the night. If you have a boat, look for creek mouths or big drops near the groves');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(2, 2, 'Redfish', 'MANGROVES', 'Fish slowly, they are everywhere, but they are deeper down in the water column. Redfish are bottom feeders with strong noses and a good sense for vibrations');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(2, 2, 'Snapper', 'REEFS', 'Avoid trying to use artificial lures, use a lighter line as their eyesight is very good, especially in clear water');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(3, 3, 'Spotted Seatrout', 'FLATS', 'Bigger trout are solitary, drift over flats and cover ground. If you start catching small trout, move on to find bigger ones');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(2, 3, 'Sheepshead', 'REEFS', 'Be patient, and bring lots of bait');
INSERT INTO species (rod_fk, reel_fk, species_id, habitat, pro_tip) VALUES(2, 2, 'Spanish Mackeral', 'DEEP_HOLES', 'Just reel, dont twist or jerk the lure, especially when fighting the fish. You will get broken off. Other fish in the school will often try to steal the lure out of its mouth and break you off');

-- manually insert FK values from rods/reels. insert into baits_species with PKs from species + baits

-- Tarpon Baits
INSERT INTO baits_species (species_fk, bait_fk) VALUES (1, 1);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (1, 2);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (1, 3);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (1, 4);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (1, 5);

-- Snook Baits
INSERT INTO baits_species (species_fk, bait_fk) VALUES (2, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (2, 8);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (2, 9);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (2, 10);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (2, 18);

-- Redfish Baits
INSERT INTO baits_species (species_fk, bait_fk) VALUES (3, 12);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (3, 13);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (3, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (3, 11);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (3, 4);

-- Snapper Baits
INSERT INTO baits_species (species_fk, bait_fk) VALUES (4, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (4, 11);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (4, 14);

-- Trout Baits
INSERT INTO baits_species (species_fk, bait_fk) VALUES (5, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (5, 15);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (5, 8);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (5, 12);

-- Sheepshead
INSERT INTO baits_species (species_fk, bait_fk) VALUES (6, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (6, 11);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (6, 16);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (6, 17);

-- Spanish Mackeral
INSERT INTO baits_species (species_fk, bait_fk) VALUES (7, 7);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (7, 18);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (7, 12);
INSERT INTO baits_species (species_fk, bait_fk) VALUES (7, 20);

