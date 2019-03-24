package study.basecamp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.basecamp.domain.Number;
import study.basecamp.exception.IdNotFoundCustomException;
import study.basecamp.repository.NumberRepository;
import study.basecamp.service.GameService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final NumberRepository numberRepository;

    @Override
    public String guessNumber(int number, int id) {
        return equlasNumbers(number , id) ? "WIN" : "Looser";
    }

    @Override
    public int makeNumber(int number) {
        Number entity = new Number();
        entity.setNumber(number);
        return numberRepository.save(entity).getId();
    }

    @Override
    public boolean equlasNumbers(int number, int id) {
        int guess;
        try {
            guess = numberRepository.findById(id).get().getNumber();
        }catch (Exception e){
            throw new IdNotFoundCustomException("Id " + id + " not found");
        }
        return number == guess;
    }


}
