package br.com.quarkus.config;

import br.com.quarkus.mappers.UserMapper;
import br.com.quarkus.userCase.UserUserCase;
import br.com.quarkus.userCase.impl.UserUserCaseImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class UserCaseConfig {

    @Produces
    public UserUserCase confgiUserUserCase(UserMapper userMapper){
        return new UserUserCaseImpl(userMapper);
    }
}
