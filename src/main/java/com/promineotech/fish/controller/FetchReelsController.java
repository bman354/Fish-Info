package com.promineotech.fish.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.fish.entities.Reel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/reels")
@OpenAPIDefinition(info = @Info(title = "Fetch Reels Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface FetchReelsController {
//@formatter:off

  @Operation(
          summary = "Returns a list of Reels and their recommended Line for a given power",
          description = "Returns a Reel and Line",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "A reel is returned",
                          content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Reel.class))),

                  @ApiResponse(
                          responseCode = "400",
                          description = "The requested parameters are invalid",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "404",
                          description = "No Reels found with those criteria",
                          content = @Content(mediaType = "application/json")),

                  @ApiResponse(
                          responseCode = "500",
                          description = "An unplanned error ocurred",
                          content = @Content(mediaType = "application/json"))
          },
          parameters = {
              @Parameter(
                      name = "fetch_reel",
                      allowEmptyValue = false,
                      required = true,
                      description = "the power of the reel requested, choose either 6000, 3000, or 2500")
      }
  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Reel>fetchReels(@RequestParam(required = false)String fetch_reel);
  //formatter:on
}
