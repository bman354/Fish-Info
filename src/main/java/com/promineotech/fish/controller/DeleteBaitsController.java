package com.promineotech.fish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
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
                            description = "Bait is deleted successfully"),

                    @ApiResponse(
                            responseCode = "400",
                            description = "The requested parameters are invalid"),

                    @ApiResponse(
                            responseCode = "404",
                            description = "No bait found with those criteria"),

                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error ocurred")
            },
            parameters = {
                @Parameter(
                        name = "delete_bait",
                        allowEmptyValue = false,
                        required = true,
                        description = "Name of bait to be deleted")
            }
    )

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void deleteBait(@RequestParam(required = false)String delete_bait);
    //formatter:on
  }
