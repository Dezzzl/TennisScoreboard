package org.dezzzl.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dezzzl.dto.NewMatchDto;
import org.dezzzl.exception.ValidationException;
import org.dezzzl.model.Match;
import org.dezzzl.model.Player;
import org.dezzzl.repository.PlayerRepository;
import org.dezzzl.validator.NewMatchValidator;
import org.dezzzl.validator.ValidationResult;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewMatchService {
    private static final NewMatchService INSTANCE = new NewMatchService();

    private final PlayerRepository playerRepository = PlayerRepository.getInstance();
    private final NewMatchValidator newMatchValidator = NewMatchValidator.getInstance();

    public static NewMatchService getInstance(){
        return INSTANCE;
    }

    public Match startNewMatch(NewMatchDto newMatchDto) throws ValidationException {
        ValidationResult validationResult = newMatchValidator.isValid(newMatchDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        Optional<Player> player1 = playerRepository.findByName(newMatchDto.player1());
        Optional<Player> player2 = playerRepository.findByName(newMatchDto.player2());

        Player player1Entity = player1.orElseGet(() -> {
            /// TODO: 18.07.2024 побробовать MapStruct
            return playerRepository.save(Player.builder().name(newMatchDto.player1()).build());
        });

        Player player2Entity = player2.orElseGet(() -> {
            return playerRepository.save(Player.builder().name(newMatchDto.player2()).build());
        });

        return Match.builder()
                .player1(player1Entity)
                .player2(player2Entity).build();
    }

}
