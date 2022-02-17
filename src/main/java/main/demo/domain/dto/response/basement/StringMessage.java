package main.demo.domain.dto.response.basement;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter@Setter
public class StringMessage extends BaseResponse{

    private String message;

    @Builder
    public StringMessage(HttpStatus status,String message) {
        super(status);
        this.message = message;
    }
}
