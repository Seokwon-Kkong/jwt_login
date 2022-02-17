package main.demo.mvc.repository;

import com.querydsl.jpa.impl.JPAUpdateClause;
import main.demo.configuration.exception.FaultParamException;
import main.demo.domain.basement.embed.Password;
import main.demo.domain.dto.request.Param_User;
import main.demo.domain.dto.response.Response_User;
import main.demo.domain.entity.user.B_User;
import main.demo.domain.entity.user.QB_User;
import main.demo.mvc.repository.basement.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class Repository_User extends BaseRepository {

    QB_User q_user = QB_User.b_User;

    public Response_User.User getUser(String id) {
        B_User user = query.selectFrom(q_user).where(q_user.account_id.eq(id)).fetchOne();
        if(user == null) {
            System.out.println("user 없음");
            return null;
        }
        return Response_User.User.builder()
                .idx(user.getIdx())
                .id(user.getAccount_id())
                .pwd(user.getPassword().getPassword())
                .refreshToken(user.getRefresh_token())
                .created(user.getCreated_at())
                .updated(user.getUpdate_at())
                .build();
    }

    public boolean checkUser(String id, String pwd) {
        B_User user = query.selectFrom(q_user).where(q_user.account_id.eq(id)).fetchOne();
        Password pass = new Password(user.getPassword().getPassword(),user.getPassword().getSalt());
        return pass.isMatched(pwd);
    }

    public Optional<B_User> getUser(String id, String pwd) {
        boolean isMatched = this.checkUser(id,pwd);
        B_User entity = null;
        if(isMatched) {
            entity = query.selectFrom(q_user).where(q_user.account_id.eq(id)).fetchOne();
        }
        return entity != null ? Optional.of(entity) : Optional.empty();
    }

    public long updateUser(String id, String newPwd) {
        JPAUpdateClause update = query.update(q_user).where(q_user.account_id.eq(id));
        update.set(q_user.password, new Password(newPwd));
        update.set(q_user.update_at, LocalDateTime.now());
        return update.execute();
    }
}

//    CREATE TABLE `test_user` (
//        `user_idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이용자 테이블 인덱스',
//        `create_time` datetime NOT NULL COMMENT '생성일',
//        `update_time` datetime NOT NULL COMMENT '업데이트 일자',
//        `user_account_token_refresh` longtext COMMENT '리프레시 토큰 값',
//        `user_account_salt` char(12) NOT NULL COMMENT '패스워드 랜덤값',
//        `user_account_id` varchar(30) NOT NULL COMMENT '이용자 계정 아이디',
//        `user_account_password` char(64) DEFAULT NULL COMMENT '이용자 계정 암호',
//        PRIMARY KEY (`user_idx`)
//        ) ENGINE=InnoDB CHARSET=utf8 COMMENT='테스트 유저 테이블';
