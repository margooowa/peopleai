package com.softserve.peopleai.countries;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  private final CountryClient countryClient;

  @Autowired
  public CountryService(CountryClient countryClient) {
    this.countryClient = countryClient;
  }

  public List<Country> retrieveCounties(String country, Long population, SortOrder sortOrder, Integer limit) {
    List<Country> filteredCountries = countryClient.getCountriesFromApi();
    if (country != null) {
      filteredCountries = filterCountriesByName(filteredCountries, country);
    }

    if (population != null) {
      filteredCountries = filterCountriesByPopulation(filteredCountries, population);
    }

    if (sortOrder != null) {
      filteredCountries = sortCountries(filteredCountries, sortOrder);
    }

    if (limit != null) {
      filteredCountries = limitRecords(filteredCountries, limit);
    }

    return filteredCountries;
  }

  protected List<Country> filterCountriesByName(List<Country> countries, String searchString) {
    String searchLowerCase = searchString.toLowerCase();

    return countries.stream()
        .filter(country -> country.getName().getCommon().toLowerCase().contains(searchLowerCase))
        .toList();
  }

  protected List<Country> filterCountriesByPopulation(List<Country> countries, Long maxPopulation) {
    return countries.stream()
        .filter(country -> country.getPopulation() < maxPopulation * 1000000)
        .toList();
  }

  protected List<Country> sortCountries(List<Country> countries, SortOrder sortOrder) {
    Comparator<Country> comparator = Comparator.comparing(v -> v.getName().getCommon());
    if (sortOrder == SortOrder.DESC) {
      comparator = comparator.reversed();
    }
    return countries.stream()
        .sorted(comparator)
        .toList();
  }

  protected List<Country> limitRecords(List<Country> records, int n) {
    return records.stream()
        .limit(n)
        .toList();
  }

}
