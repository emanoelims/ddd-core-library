package dev.emanoel.core.validation;

/**
 * responsible for validating fields.
 *
 * @param <F> field to be validated.
 */
public class Validation<F> {
  private final F field;

  private Validation(final F field) {
    this.field = field;
  }

  public static <F> Validation<F> of(final F field) {
    return new Validation<>(field);
  }
}
