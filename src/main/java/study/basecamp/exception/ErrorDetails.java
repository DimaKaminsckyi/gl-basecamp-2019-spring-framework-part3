package study.basecamp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

    private int errCode;
    private String errMessage;

    public ErrorDetails(int errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
}
