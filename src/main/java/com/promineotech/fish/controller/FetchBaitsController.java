package com.promineotech.fish.controller;

import java.util.List;
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

@RequestMapping("/fetchbaits")
@OpenAPIDefinition(info = @Info(title = "Baits Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface FetchBaitsController {
  @Operation(
      summary = "Baits",
      description = "Fetch Baits",
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
                      description = "No baits found with those criteria",
                      content = @Content(mediaType = "application/json")),

              @ApiResponse(
                      responseCode = "500",
                      description = "An unplanned error ocurred",
                      content = @Content(mediaType = "application/json"))
      },
      parameters = {          
          @Parameter(
                  name = "fetch_baits",
                  allowEmptyValue = false,
                  required = true,
                  description = "the name of bait requested"),
          @Parameter(
                  name = "fetch_baits_isNatural",
                  allowEmptyValue = false,
                  required = true,
                  description = "request all baits based on if they are natural or artificial, true for natural, false for artificial"),
      }
)

@GetMapping
@ResponseStatus(code = HttpStatus.OK)
List<Bait>fetchBaits(@RequestParam(required = true)String fetch_baits, @RequestParam(required = true) Boolean fetch_baits_isNatural);
//formatter:on
}
