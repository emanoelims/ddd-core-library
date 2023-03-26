package dev.emanoel.core.validation;

import static java.util.Objects.requireNonNull;

/**
 * responsible for validating fields.
 *
 * @param <F> field to be validated.
 */
public class Validation<F> {
  private final F field;
  private String errorMessage;

  private Validation(final F field) {
    this.field = field;
  }

  public static <F> Validation<F> of(final F field) {
    return new Validation<>(field);
  }

  /**
   * Checks if the field is null.
   *
   * @param errorMessage error message for failed validation.
   * @return Validation
   */
  public Validation<F> checkNull(final String errorMessage) {
    if (field == null) {
      this.errorMessage = errorMessage;
    }
    return this;
  }

  /**
   * Check if the field is empty.
   *
   * @param errorMessage error message for failed validation.
   * @return Validation
   */
  public Validation<F> checkEmpty(final String errorMessage) {
    var fieldString = convertFieldToString(requireNonNull(field));
    if (fieldString.isBlank()) {
      this.errorMessage = errorMessage;
    }
    return this;
  }

  private String convertFieldToString(final F field) {
    return (field instanceof String) ? (String) field : null;
  }

  public boolean failure() {
    return errorMessage != null && !errorMessage.isEmpty();
  }

  public String errorMessage() {
    return errorMessage;
  }
}
