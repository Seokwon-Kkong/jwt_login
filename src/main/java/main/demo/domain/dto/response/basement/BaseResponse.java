package main.demo.domain.dto.response.basement;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseResponse {
    private Integer code;
    private String message;

    public BaseResponse(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

}
