package com.promineotech.fish.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Species {
  String species_id;
  Rod rod;
  Reel reel;
  Habitat habitat;
  String pro_tip;
}
