package main.demo.utilization;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AESCrypt {
    private final String IV = "HCGyCG84ZY67dHLlizZMdA==";
    private final String SECRET = "fi/BUG7DrhFhNCTIx7l1nSuO5Q3M37dHYx/Ws0uan48=";

    public String encrypt(String plain){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.getDecoder().decode(SECRET),"AES"), new IvParameterSpec(Base64.getDecoder().decode(IV)));
            return new String(Base64.getEncoder().encode(cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8))));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  String decrypt(String cypher){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.getDecoder().decode(SECRET), "AES"), new IvParameterSpec(Base64.getDecoder().decode(IV)));
            return new String(cipher.doFinal(Base64.getDecoder().decode(cypher)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
