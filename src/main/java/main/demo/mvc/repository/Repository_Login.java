package main.demo.mvc.repository;

import main.demo.domain.dto.response.Response_User;
import main.demo.domain.entity.user.B_User;
import main.demo.domain.entity.user.QB_User;
import main.demo.mvc.repository.basement.BaseRepository;
import org.springframework.stereotype.Repository;
@Repository
public class Repository_Login extends BaseRepository {

    QB_User q_user = QB_User.b_User;

    public Response_User.User getUser(String uuid) {
        B_User user = query.selectFrom(q_user).fetchOne();
        return
    }
}
