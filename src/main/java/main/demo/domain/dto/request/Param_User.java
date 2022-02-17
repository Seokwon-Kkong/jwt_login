package main.demo.domain.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Param_User {


    @Getter@Setter
    public static class User {

        private String uuid;
        private String id;
        private String pwd;
        private String newPwd;

        @Builder
        public User(String uuid, String id, String pwd,String newPwd) {
            this.uuid = uuid;
            this.id = id;
            this.pwd = pwd;
            this.newPwd = newPwd;
        }
    }

}
