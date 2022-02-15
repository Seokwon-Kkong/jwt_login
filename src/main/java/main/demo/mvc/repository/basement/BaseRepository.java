package main.demo.mvc.repository.basement;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {

    @Autowired
    public JPAQueryFactory query;
}
