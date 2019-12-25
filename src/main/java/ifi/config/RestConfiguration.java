package ifi.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${trainer.service.username}")
    String user;

    @Value("${trainer.service.password}")
    String pass;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate trainerApiRestTemplate() {
        BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(user,pass);
        RestTemplate rest = new RestTemplate();
        rest.getInterceptors().add(interceptor);
        return rest;
    }
}