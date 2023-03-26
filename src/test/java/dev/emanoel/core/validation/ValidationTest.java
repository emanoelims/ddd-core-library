package dev.emanoel.core.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

  @Test
  void givenAValidParam_whenCallOf_thenReturnAnInstanceOfValidation() {
    var param = "";

    var actualValidation = Validation.of(param);

    assertNotNull(actualValidation);
  }
}
