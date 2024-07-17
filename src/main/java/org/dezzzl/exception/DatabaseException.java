package org.dezzzl.exception;

import lombok.Getter;
import org.dezzzl.validator.Error;

@Getter
public class DatabaseException extends RuntimeException {
    private final Error error = Error.of("database.error", "the database is unavailable");
}
