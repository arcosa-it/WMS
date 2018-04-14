package com.websystique.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("richard").password("123456").roles("USER").and().
                                      withUser("admin").password("123456").roles("ADMIN").and().
                                      withUser("dba").password("123456").roles("DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin_*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dba_*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().
                 formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password").and()
                .logout().logoutSuccessUrl("/login?logout").and().csrf();

    }
}
