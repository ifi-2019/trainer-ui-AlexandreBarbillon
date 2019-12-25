package ifi.config;

import ifi.pokemonTypes.bo.Trainer;
import ifi.pokemonTypes.service.TrainerService;
import ifi.pokemonTypes.service.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    TrainerService trainerService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                Trainer trainer = trainerService.getTrainer(s);
                if(trainer != null){
                    return User.builder().username(trainer.getName()).password(trainer.getPassword()).authorities("ROLE_USER").build();
                }
                throw new BadCredentialsException("No such user");
            }
        };
    }

    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}
