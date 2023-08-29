package com.softserve.peopleai.countries;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.softserve.peopleai.countries.Country.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

  @Mock
  private CountryClient countryClient;

  @InjectMocks
  private CountryService countryService;

  @Test
  void testRetrieveCounties_withAllFilters() {

    when(countryClient.getCountriesFromApi()).thenReturn(getCountries());

    // Test parameters
    String country = "Samoa";
    Long population = 1L;
    SortOrder sortOrder = SortOrder.DESC;
    Integer limit = 1;

    // Call the method
    List<Country> result = countryService.retrieveCounties(country, population, sortOrder, limit);

    // Assertion
    assertEquals(1, result.size());
    assertEquals("Samoa", result.get(0).getName().getCommon());
  }

  @Test
  void testFilterCountriesByName() {

    // Call the method
    List<Country> result = countryService.filterCountriesByName(getCountries(), "SA");

    // Assertion
    assertEquals(2, result.size());
  }

  @Test
  void testFilterCountriesByPopulation() {

    // Call the method
    List<Country> result = countryService.filterCountriesByPopulation(getCountries(), 1L);

    // Assertion
    assertEquals(2, result.size());
  }

  @Test
  void testSortCountries() {

    // Call the method
    List<Country> result = countryService.sortCountries(getCountries(), SortOrder.ASC);

    // Assertion
    assertEquals("Guinea", result.get(0).getName().getCommon());
  }

  @Test
  void testLimitRecords() {

    // Call the method
    List<Country> result = countryService.limitRecords(getCountries(), 1);

    // Assertion
    assertEquals(1, result.size());
  }

  private List<Country> getCountries() {
    return Arrays.asList(
        Country.builder().name(Name.builder().common("Samoa").build()).population(9000L).build(),
        Country.builder().name(Name.builder().common("Samoa Guinea").build()).population(900000000000L).build(),
        Country.builder().name(Name.builder().common("Guinea").build()).population(9000L).build());
  }
}
