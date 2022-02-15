package main.demo.domain.dto.response.basement;


import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObjectMessage<T> extends BaseResponse {

    private T data;

    @Builder
    public ObjectMessage(HttpStatus status, T data) {
        super(status);
        this.data = data;
    }
}
