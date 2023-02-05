package com.promineotech.fish.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bait {
  int bait_pk;
  String bait_id;
  Boolean isNatural;  
}
