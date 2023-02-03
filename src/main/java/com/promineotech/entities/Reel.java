package com.promineotech.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reel {
  String reel_name;
  String reel_power;
  LineType lineType;
  int lineWeight;
}
