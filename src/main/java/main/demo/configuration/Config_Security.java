package main.demo.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity // 웹 보안 활성화를 위한 annotation => SpringSecurityFilterChain에 등록됨.
public class Config_Security extends WebSecurityConfigurerAdapter {

    // HttpSecurity
    // A HttpSecurity is similar to Spring Security's XML <http> element in the namespace configuration.
    // It allows configuring web based security for specific http requests
    // By default it will be applied to all requests, but can be restricted using requestMatcher(RequestMatcher) or other similar methods.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable();
    }

    // WebSecurity
    // Customizations to the WebSecurity can be made by creating a WebSecurityConfigurer,
    // overriding WebSecurityConfigurerAdapter or exposing a WebSecurityCustomizer bean.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
