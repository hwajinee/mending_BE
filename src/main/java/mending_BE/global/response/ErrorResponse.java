package mending_BE.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mending_BE.global.exception.CustomException;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;
    private final int status;

    public static ErrorResponse of(CustomException e) {
        return new ErrorResponse(
                e.getErrorCode().getCode(),
                e.getErrorCode().getMessage(),
                e.getErrorCode().getHttpStatus().value()
        );
    }
}