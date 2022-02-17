package main.demo.mvc.service;


import main.demo.domain.dto.request.Param_User;
import main.demo.domain.dto.response.Response_User;
import main.demo.domain.dto.response.basement.ObjectMessage;


public interface Service_Login {

    public ObjectMessage<Response_User.User> getUser(String id);

    public ObjectMessage<Response_User.User> addUser(Param_User.User parameter);

    public ObjectMessage<Response_User.User> checkUser(String id, String pwd);

    public ObjectMessage<Response_User.User> deleteUser(Param_User.User parameter);

    public ObjectMessage<Response_User.User> updateUser(Param_User.User parameter);
}
