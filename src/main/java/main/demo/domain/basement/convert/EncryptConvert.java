package main.demo.domain.basement.convert;


import main.demo.utilization.AESCrypt;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Converter // 엔티티 <-> 데이터 베이스 사이에서 데이터 변경해줌
public class EncryptConvert implements AttributeConverter<String, Long> {


    @Override
    public Long convertToDatabaseColumn(String input) {
        return Long.parseLong(new AESCrypt().decrypt(URLDecoder.decode(input, StandardCharsets.UTF_8)).substring(12));
    }

    @Override
    public String convertToEntityAttribute(Long output) {
        return URLEncoder.encode(new AESCrypt().encrypt(RandomStringUtils.randomAlphabetic(12) + output.toString()), StandardCharsets.UTF_8);
    }
}
