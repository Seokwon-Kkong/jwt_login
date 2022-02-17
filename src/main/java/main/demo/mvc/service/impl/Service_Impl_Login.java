package main.demo.mvc.service.impl;

import main.demo.domain.dto.request.Param_User;
import main.demo.domain.dto.response.Response_User;

import main.demo.domain.dto.response.basement.ObjectMessage;
import main.demo.domain.entity.user.B_User;
import main.demo.mvc.repository.Repository_User;
import main.demo.mvc.service.Service_Login;
import main.demo.mvc.service.basement.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class Service_Impl_Login extends BaseService<Repository_User> implements Service_Login {

    private final Repository_User loginRepository;

    public Service_Impl_Login(Repository_User loginRepository, EntityManager em) {
        super(loginRepository, em);
        this.loginRepository = loginRepository;
    }

    @Override
    public ObjectMessage<Response_User.User> getUser(String id) {
        return ObjectMessage.<Response_User.User>builder()
                .status(HttpStatus.OK)
                .data(repository.getUser(id))
                .build();
    }

    @Override
    @Transactional
    public ObjectMessage<Response_User.User> addUser(Param_User.User param) {
        B_User user = B_User.builder()
                .password(param.getPwd())
                .account_id(param.getId())
                .build();

        em.persist(user);

        return null;
    }

    @Override
    public ObjectMessage<Response_User.User> checkUser(String id, String pwd) {
        boolean result = repository.checkUser(id,pwd);
        if(result) {
            return ObjectMessage.<Response_User.User>builder()
                    .status(HttpStatus.OK)
                    .data(repository.getUser(id))
                    .build();
        } else {
            return ObjectMessage.<Response_User.User>builder()
                    .status(HttpStatus.OK)
                    .data(null)
                    .build();
        }
    }

    @Override
    @Transactional
    public ObjectMessage<Response_User.User> deleteUser(Param_User.User param) {
        Optional<B_User> entity = repository.getUser(param.getId(), param.getPwd());
        if (entity.isEmpty()) {
            return ObjectMessage.<Response_User.User>builder()
                .status(HttpStatus.OK)
                .data(null)
                .build();
        }
        em.remove(entity.get());
        return ObjectMessage.<Response_User.User>builder()
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    @Transactional
    public ObjectMessage<Response_User.User> updateUser(Param_User.User param) {
        boolean isMatched = repository.checkUser(param.getId(),param.getPwd());
        if(isMatched) {
            repository.updateUser(param.getId(), param.getNewPwd());
        }
        return null;
    }


}
