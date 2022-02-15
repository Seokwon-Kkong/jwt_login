package main.demo.configuration;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class Config_Querydsl {

    // 엔티티의 생명 주기와 트랜잭션 등을 관리함.
    @PersistenceContext
    private EntityManager em;

    // JPAQueryFactory - EntityManager을 생성하기 위한 클래스
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }


}
