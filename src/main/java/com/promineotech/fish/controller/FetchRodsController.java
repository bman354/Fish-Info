package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.fish.entities.Rod;
import com.promineotech.fish.entities.RodAction;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/rods")
@OpenAPIDefinition(info = @Info(title = "Fetch Rod Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface FetchRodsController {
//@formatter:off

  @Operation(
          summary = "Returns a Fishing Rod ",
          description = "Returns a list of Fishing Rods and their specifications",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "A Fishing Rod and its recommendations gets returned",
                          content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Rod.class))),

                  @ApiResponse(
                          responseCode = "400",
                          description = "The requested parameters are invalid",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "404",
                          description = "No Rod found with those criteria",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "500",
                          description = "An unplanned error ocurred",
                          content = @Content(mediaType = "application/json"))
          },
          parameters = {
              @Parameter(
                      name = "fetch_rods",
                      allowEmptyValue = false,
                      required = true,
                      description = "Action of the requested bait, options are LIGHT, MEDIUM, or HEAVY")
      }
  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Rod>fetchRod(@RequestParam(required = false)RodAction fetch_rods);
  //formatter:on
}