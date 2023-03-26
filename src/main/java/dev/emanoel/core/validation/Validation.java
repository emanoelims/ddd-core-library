package dev.emanoel.core.validation;

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

  public boolean failure() {
    return errorMessage != null && !errorMessage.isEmpty();
  }

  public String errorMessage() {
    return errorMessage;
  }
}
