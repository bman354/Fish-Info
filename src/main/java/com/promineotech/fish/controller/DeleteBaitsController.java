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

@RequestMapping("/deletebaits")
@OpenAPIDefinition(info = @Info(title = "Baits Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})


public interface DeleteBaitsController {
  //@formatter:off
    @Operation(
            summary = "Delete Baits",
            description = "Delete baits",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bait is deleted successfully",
                            content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bait.class))),

                    @ApiResponse(
                            responseCode = "400",
                            description = "The requested parameters are invalid",
                            content = @Content(mediaType = "application/json")),

                    @ApiResponse(
                            responseCode = "404",
                            description = "No bait found with those criteria",
                            content = @Content(mediaType = "application/json")),

                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error ocurred",
                            content = @Content(mediaType = "application/json"))
            },
            parameters = {
                @Parameter(
                        name = "delete_bait",
                        allowEmptyValue = false,
                        required = true,
                        description = "Name of bait to be deleted")
            }
    )

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Bait deleteBait(@RequestParam(required = false)String delete_bait);
    //formatter:on
  }
