package main.demo.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class Response_User {

    @Getter
    public static class User {
        private Long idx;
        private String id;
        private String pwd;
        private String accessToken;
        private String refreshToken;
        private LocalDateTime created;
        private LocalDateTime updated;

        @Builder
        public User(Long idx, String id, String pwd, String accessToken, String refreshToken, LocalDateTime created, LocalDateTime updated) {
            this.idx = idx;
            this.id = id;
            this.pwd = pwd;
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.created = created;
            this.updated = updated;
        }
    }
}
