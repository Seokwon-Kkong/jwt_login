package main.demo.domain.basement;


import lombok.Getter;
import main.demo.domain.basement.convert.EncryptConvert;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass // 상속 받는 역할만 하기 위해
@Getter
public class BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    @Convert(converter = EncryptConvert.class)
    private String encrypt ;

    @Column(name = "update_time", updatable = false, nullable = false)
    @UpdateTimestamp
    private LocalDateTime update_at;

    @Column(name = "create_time", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
}
