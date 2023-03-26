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

  @Test
  void givenNullParam_whenCallCheckNull_thenValidationShouldFail() {
    var param = (String) null;
    var expectedErrorMessage = "'name' cannot be null";

    var actualValidation = Validation.of(param).checkNull(expectedErrorMessage);

    assertTrue(actualValidation.failure());
    assertEquals(expectedErrorMessage, actualValidation.errorMessage());
  }
}
