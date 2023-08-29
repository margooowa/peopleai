package com.softserve.peopleai.countries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  private final CountryClient countryClient;

  @Autowired
  public CountryService(CountryClient countryClient) {
    this.countryClient = countryClient;
  }

  public List<Country> retrieveCounties() {
    List<Country> countriesAll = countryClient.getCountriesFromApi();
    return countriesAll;
  }

  public List<Country> filterCountriesByName(List<Country> countries, String searchString) {
    String searchLowerCase = searchString.toLowerCase();

    return countries.stream()
        .filter(country -> country.getName().getCommon().toLowerCase().contains(searchLowerCase))
        .collect(Collectors.toList());
  }
}
