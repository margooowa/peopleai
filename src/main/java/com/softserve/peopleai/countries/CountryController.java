package com.softserve.peopleai.countries;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping(value = "/countries", produces = {MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<List<Country>> getCountries(
      @RequestParam(required = false) String country,
      @RequestParam(required = false) Long population,
      @RequestParam(required = false) SortOrder sortOrder,
      @RequestParam(required = false) Integer limit) {

    return ResponseEntity.ok(countryService.retrieveCounties(country, population, sortOrder, limit));
  }
}
