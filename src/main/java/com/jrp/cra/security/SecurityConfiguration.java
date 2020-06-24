package com.jrp.cra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication()
                /*.withDefaultSchema()
                .withUser("myuser")
                    .password("pass")
                    .roles("USER")
                .and()
                .withUser("ant")
                    .password("pass2")
                    .roles("USER")
                .and()
                .withUser("manager")
                    .password("pass3")
                    .roles("ADMIN")*/

                .usersByUsernameQuery("select username, password, enabled " +
                        "from user_accounts " +
                        "where username = ?")
                .authoritiesByUsernameQuery("select username, role " +
                        "from user_accounts " +
                        "where username = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/course/new").hasAuthority("ADMIN")
                .antMatchers("/course/save").hasAuthority("ADMIN")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin();
    }
}
