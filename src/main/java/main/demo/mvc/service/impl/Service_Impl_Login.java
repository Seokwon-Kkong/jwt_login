package main.demo.mvc.service.impl;

import main.demo.domain.dto.response.Response_User;

import main.demo.domain.dto.response.basement.ObjectMessage;
import main.demo.mvc.repository.Repository_Login;
import main.demo.mvc.service.Service_Login;
import main.demo.mvc.service.basement.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class Service_Impl_Login extends BaseService<Repository_Login> implements Service_Login {

    private final Repository_Login loginRepository;

    public Service_Impl_Login(Repository_Login loginRepository, EntityManager em) {
        super(loginRepository, em);
        this.loginRepository = loginRepository;
    }

    @Override
    public ObjectMessage<Response_User.User> getUser(String uuid) {
        return ObjectMessage.<Response_User.User>builder()
                .status(HttpStatus.OK)
                .data(repository.getUser(uuid))
                .build();
    }
}
