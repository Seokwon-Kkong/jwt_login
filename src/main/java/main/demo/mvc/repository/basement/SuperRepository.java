package main.demo.mvc.repository.basement;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SuperRepository {

    @Autowired
    public JPAQueryFactory query;
}
