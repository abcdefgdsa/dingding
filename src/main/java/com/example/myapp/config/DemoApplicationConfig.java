package com.example.myapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 设置用户和角色
 */
@Slf4j
@Configuration
public class DemoApplicationConfig {

    /**
     * 添加Security的用户
     * @return
     */
    @Bean
    public UserDetailsService myUserDetailsService(){
//        把用户存储在内存中
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        构造用户的信息
        String[][] usersGroupAndRoles= {
                {"107770081","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"107770190","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"107770310","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"545142099","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"661205427","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"661260524","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"661261433","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"661262569","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"661628274","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"662134279","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"662228237","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"782935785","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"903272665","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"905992062","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"other","password","ROLE_ACTIVITI_USER","GROUP_otherTeam"},
                {"system","password","ROLE_ACTIVITI_USER"},
                {"admin","password","ROLE_ACTIVITI_ADMIN"}
        };

        for (String[] users : usersGroupAndRoles) {
//            用户的角色和组
            List<String> authStrList = Arrays.asList(Arrays.copyOfRange(users, 2, users.length));

            log.info("> Registering new user: {} with the following Authorities[{}]",users[0],authStrList);

            inMemoryUserDetailsManager.createUser(new User(users[0],
                    passwordEncoder().encode(users[1]),
                    authStrList.stream().map(str -> new SimpleGrantedAuthority(str)).collect(Collectors.toList())));
        }
        return inMemoryUserDetailsManager;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
