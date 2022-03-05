package br.com.quarkus.userCase;

import br.com.quarkus.userCase.entities.User;

public interface UserUserCase extends BaseUserCase<User>{
    User findByUserName(String userName);
}
