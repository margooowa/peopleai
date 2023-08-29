package com.softserve.peopleai.countries;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

  private Name name;

  private List<String> tld;

  private String cca2;

  private String ccn3;

  private String cca3;

  private String cioc;

  private boolean independent;

  private String status;

  private boolean unMember;

  private Map<String, Currency> currencies;

  private Idd idd;

  private List<String> capital;

  private List<String> altSpellings;

  private String region;

  private String subregion;

  private Map<String, String> languages;

  private Translations translations;

  private List<Double> latlng;

  private boolean landlocked;

  private List<String> borders;

  private double area;

  private Demonyms demonyms;

  private String flag;

  private Maps maps;

  private Long population;

  private Gini gini;

  private String fifa;

  private Car car;

  private List<String> timezones;

  private List<String> continents;

  private Flags flags;

  private CoatOfArms coatOfArms;

  private String startOfWeek;

  private CapitalInfo capitalInfo;

  private PostalCode postalCode;

  // getters and setters for each field

  @Getter
  @Setter
  static class Name {

    private String common;

    private String official;

    private Map<String, NativeName> nativeName;


  }

  @Getter
  @Setter
  static class NativeName {

    private String official;

    private String common;


  }

  @Getter
  @Setter
  static class Currency {

    private String name;

    private String symbol;


  }

  @Getter
  @Setter
  static class Idd {

    private String root;

    private List<String> suffixes;


  }

  @Getter
  @Setter
  static class Translations {

    private Map<String, Translation> translations;


  }

  @Getter
  @Setter
  static class Translation {

    private String official;

    private String common;


  }

  @Getter
  @Setter
  static class Demonyms {

    private Map<String, Demonym> demonyms;


  }

  @Getter
  @Setter
  static class Demonym {

    private String f;

    private String m;

  }

  @Getter
  @Setter
  static class Gini {

    private double _2014;


  }

  @Getter
  @Setter
  static class Car {

    private List<String> signs;

    private String side;


  }

  @Getter
  @Setter
  static class Flags {

    private String png;

    private String svg;

    private String alt;


  }

  @Getter
  @Setter
  static class CoatOfArms {

    private String png;

    private String svg;


  }

  @Getter
  @Setter
  static class Maps {

    private String googleMaps;

    private String openStreetMaps;


  }

  @Getter
  @Setter
  static class CapitalInfo {

    private List<Double> latlng;


  }

  @Getter
  @Setter
  static class PostalCode {

    private String format;

    private String regex;


  }
}
