package org.dezzzl.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value(staticConstructor = "of")
public class Error {
     String code;
     String message;
}
