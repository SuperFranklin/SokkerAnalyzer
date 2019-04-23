package com.slupski.api;

import com.slupski.commons.Settings;
import org.springframework.beans.factory.annotation.Autowired;


public class BasicAuthConfiguration{

//public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    Settings settings;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user")
//            .password("password")
//            .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http)
//            throws Exception {
//        http.csrf().disable()
//             .authorizeRequests()
//             .antMatchers("/login").permitAll()
//             .anyRequest()
//             .authenticated()
//             .and()
//             .httpBasic();
//    }
}
