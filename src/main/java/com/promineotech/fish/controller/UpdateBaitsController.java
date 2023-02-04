package com.promineotech.fish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.fish.entities.Bait;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/updatebaits")
@OpenAPIDefinition(info = @Info(title = "Update Baits Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UpdateBaitsController {
//@formatter:off

  @Operation(
          summary = "Update Baits",
          description = " Update baits",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Value is returned successfully",
                          content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Bait.class))),

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
                      name = "old_bait_name",
                      allowEmptyValue = false,
                      required = true,
                      description = "Original name of bait to be updated"),
              @Parameter(
                      name = "old_bait_isNatural",
                      allowEmptyValue = false,
                      required = true,
                      description = "Original Boolean value if bait is natural"),
              @Parameter(
                      name = "new_bait_name",
                      allowEmptyValue = false,
                      required = true,
                        description = "New name of bait to be updated"),
          @Parameter(
                      name = "new_bait_isNatural",
                      allowEmptyValue = false,
                      required = true,
                      description = "New Boolean value if bait to be updated is natural")

          }
  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Bait updateBait(
      @RequestParam(required = false)String old_bait_name, 
      @RequestParam(required = false) Boolean old_bait_isNatural,
      @RequestParam(required = false)String new_bait_name, 
      @RequestParam(required = false) Boolean new_bait_isNatural);
  //formatter:on

}
