package org.lsh.merak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/11 14:12
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //基于内存的用户存储
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
//        //基于数据库表的认证
//        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()//自定义登录页面
                .loginPage("/login")
            .and()
            .logout()//退出登录
                .logoutSuccessUrl("/")
            .and()
            .rememberMe()//启用记住我
                .tokenValiditySeconds(3600)
                .key("merakKey")
            .and()
            .authorizeRequests()//过滤
                .antMatchers("/index").anonymous()
                .anyRequest().authenticated();
    }
}
