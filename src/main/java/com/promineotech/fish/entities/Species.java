package com.promineotech.fish.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Species {
  private String species_id;
  private Rod rod;
  private Reel reel;
  private Habitat habitat;
  private String pro_tip;
  private List<Bait> baits;
}
