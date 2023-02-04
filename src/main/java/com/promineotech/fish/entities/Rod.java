package com.promineotech.fish.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rod {
  String rod_id;
  RodAction rodAction;
  RodTipAction rodTipAction;
  int rodLengthInch;
}
