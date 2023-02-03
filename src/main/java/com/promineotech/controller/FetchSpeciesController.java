package com.promineotech.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.entities.Species;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface FetchSpeciesController {
//@formatter:off

  @Operation(
          summary = "Returns a Species and its fishing recommendations",
          description = "Returns a Species and a recommended Rod, Reel, Baits, Habitat, and a tip from a Fishing Pro",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "A fish species and its recommendations gets returned",
                          content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Species.class))),

                  @ApiResponse(
                          responseCode = "400",
                          description = "The requested parameters are invalid",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "404",
                          description = "No fish species found with those criteria",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "500",
                          description = "An unplanned error ocurred",
                          content = @Content(mediaType = "application/json"))
          },
          parameters = {
                  @Parameter(
                          name = "Species Name",
                          allowEmptyValue = false,
                          required = true,
                          description = "the name of species requested, choose either Tarpon, Snook, Redfish, Snapper, Spotted Seatrout, Sheepshead, or Spanish Mackeral"),
          }
  )

  @GetMapping("/species")
  @ResponseStatus(code = HttpStatus.OK)
  List<Species>fetchSpecies(@RequestParam(required = false)String species);
  //formatter:on
}
