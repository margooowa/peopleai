package com.softserve.peopleai.countries;

import java.util.Arrays;
import java.util.List;

import com.softserve.peopleai.countries.config.exception.EntriesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryClient {

  private final String API_URL = "https://restcountries.com/v3.1/all";

  private final RestTemplate restTemplate;

  @Autowired
  public CountryClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public List<Country> getCountriesFromApi() {
    Country[] countries = restTemplate.getForObject(API_URL, Country[].class);
    if (countries == null) {
      throw new EntriesNotFoundException();
    }
    return Arrays.asList(countries);
  }

}
