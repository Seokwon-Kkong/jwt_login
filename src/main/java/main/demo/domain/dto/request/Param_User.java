package main.demo.domain.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Param_User {


    @Getter@Setter
    public static class Add {

        private String uuid;
        private String user_id;
        private String user_pwd;

        @Builder
        public Add(String uuid, String user_id, String user_pwd) {
            this.uuid = uuid;
            this.user_id = user_id;
            this.user_pwd = user_pwd;
        }
    }

}
