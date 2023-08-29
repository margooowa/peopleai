package com.softserve.peopleai.countries;

import java.util.Collections;
import java.util.Comparator;
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

  public List<Country> filterCountriesByPopulation(List<Country> countries, Long maxPopulation) {
    return countries.stream()
        .filter(country -> country.getPopulation() < maxPopulation * 1000000)
        .collect(Collectors.toList());
  }

  public void sortCountries(List<Country> countries, SortOrder sortOrder) {
    Collections.sort(countries, (country1, country2) -> {
      if (sortOrder == SortOrder.ASC) {
        return country1.getName().getCommon().compareTo(country2.getName().getCommon());
      } else {
        return country2.getName().getCommon().compareTo(country1.getName().getCommon());
      }
    });
  }

}
