package main.demo.mvc.service;


import main.demo.domain.dto.response.Response_User;
import main.demo.domain.dto.response.basement.ObjectMessage;


public interface Service_Login {

    public ObjectMessage<Response_User.User> getUser(String uuid);
}
