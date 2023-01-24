package com.adidas.backend.adiclubservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.adidas.backend.adiclubservice.dto.AdiClubMemberInfoDto;

@RestController
@RequestMapping(value = "/adiclub")
public class AdiClubRestController {
  private static final Random RANDOM = new Random(System.nanoTime());
    @Operation(summary = "/getAdiClubMemberInfo", description = "Operation to get Info.", tags = "AdiclubInfo")
    @ApiResponse(responseCode = "201", description = "Returns Created",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Info validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
  @GetMapping
  public ResponseEntity<AdiClubMemberInfoDto> getAdiClubMemberInfo(
      @RequestParam(value = "emailAddress") final String emailAddress) {

    return ResponseEntity
        .ok()
        .body(AdiClubMemberInfoDto
            .builder()
            .email(emailAddress)
            .points(RANDOM.nextInt(5000))
            .registrationDate(Instant.now().minus(RANDOM.nextInt(365), ChronoUnit.DAYS))
            .build()
        );
  }
    @GetMapping(value = "/hello")
    public ResponseEntity<String> getAHello() {

        return ResponseEntity
            .ok()
            .body("Hello World Adiclub"
                );

    }
}
