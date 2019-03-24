package study.basecamp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.basecamp.service.GameService;
import study.basecamp.wire.NumberResponse;
import study.basecamp.wire.SaveNumberResponse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@RestController
@Validated
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}/{number}")
    public ResponseEntity<NumberResponse> getNumber(@PathVariable int id ,
                                                    @PathVariable @Min(1) @Max(20) int number) {

        NumberResponse body = new NumberResponse();
        body.setId(id);
        body.setNumber(number);
        body.setResponse(gameService.guessNumber(number , id));
        return ResponseEntity.ok(body);
    }

    @PostMapping("/{number}")
    public ResponseEntity<SaveNumberResponse> saveNumber( @PathVariable @Min(1) @Max(20) int number){
        SaveNumberResponse body = new SaveNumberResponse();
        body.setNumber(number);
        body.setId(gameService.makeNumber(number));
        return new ResponseEntity<>(body , HttpStatus.CREATED);
    }
}
