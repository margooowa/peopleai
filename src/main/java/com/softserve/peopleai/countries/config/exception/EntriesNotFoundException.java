package com.softserve.peopleai.countries.config.exception;

public class EntriesNotFoundException extends RuntimeException {

  public EntriesNotFoundException() {
    super("No entries found from the API.");
  }
}
