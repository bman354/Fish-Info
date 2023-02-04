package com.promineotech.fish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class FishInfo {
  public static void main(String[] args) {

    SpringApplication.run(FishInfo.class, args);

  }
}

// Layers: controller (swagger) DAO, Service, entity, Full CRUD on one: CRUD on Baits, read on rest
// Controllers: 1 controller per entity OR one controller for each part of CRUD
