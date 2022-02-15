package main.demo.domain.basement.embed;

import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Embeddable;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
@Getter
@Embeddable
public class Password {
    private String password;
    private String salt;

    public Password(String password) {
        String random = RandomStringUtils.randomAlphabetic(12);
        this.salt = random;
        this.password = password;
    }

    public boolean isMatched(String input) {
        return password.equals(encrypt(input, salt));
    }

    private String encrypt(String password, String salt) {
        return Hashing.sha256().hashString(password + salt, StandardCharsets.UTF_8).toString();
    }
}
