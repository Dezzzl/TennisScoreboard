package org.dezzzl.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dezzzl.dto.NewMatchDto;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewMatchValidator implements Validator<NewMatchDto> {

    private static final NewMatchValidator INSTANCE = new NewMatchValidator();

    public static NewMatchValidator getInstance(){
        return  INSTANCE;
    }

    @Override
    public ValidationResult isValid(NewMatchDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.player1()==null){
            validationResult.add(Error.of("null.player", "player1 is Null"));
        }
        if (object.player2()==null){
            validationResult.add(Error.of("null.player", "player2 is Null"));
        }
        else if (Objects.equals(object.player1(), object.player2())){
            validationResult.add(Error.of("duplicate.name", "Player names must be different"));
        }
        return validationResult;
    }


}
