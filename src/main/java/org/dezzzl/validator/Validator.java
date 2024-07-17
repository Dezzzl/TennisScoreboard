package org.dezzzl.validator;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
