package com.promineotech.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bait {
  String bait_id;
  Boolean isNatural;  
}
