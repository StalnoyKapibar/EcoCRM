package ru.javamentor.EcoCRM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
//@Order(2)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private SuccessRedirectHandler successRedirectHandler;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password(getEncoder().encode("root")).roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api/petition").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser").passwordParameter("password").usernameParameter("email")
                .permitAll().successHandler(successRedirectHandler).failureHandler(failureHandler)
                .and()
                .logout()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}


