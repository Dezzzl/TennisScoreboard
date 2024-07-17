package org.dezzzl.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dezzzl.validator.Error;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationException extends Exception{
    private final List<Error> errors;
}
