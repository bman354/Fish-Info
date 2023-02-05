package com.promineotech.fish.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reel {
  int reel_pk;
  String reel_name;
  String reel_power;
  LineType lineType;
  int lineWeight;
}
