package com.promineotech.fish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;


@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class FishInfo {
  public static void main(String[] args) {

    SpringApplication.run(FishInfo.class, args);

  }
}

// Layers: controller (swagger) DAO, Service, entity, Full CRUD on one: CRUD on Baits, read on rest
// Controllers: 1 controller per entity OR one controller for each part of CRUD
// 1 per entity: easy control on each individual entity, easy to debug, more endpoints
// 1 per CRUD, only 4 endpoints, but harder to debug/make flexible