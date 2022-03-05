package br.com.quarkus.userCase.impl;

import br.com.quarkus.bd.UserEntity;
import br.com.quarkus.mappers.UserMapper;
import br.com.quarkus.userCase.UserUserCase;
import br.com.quarkus.userCase.entities.User;
import br.com.quarkus.userCase.exception.CreateException;

import java.util.List;
import java.util.stream.Collectors;


public class UserUserCaseImpl implements UserUserCase {

    UserMapper userMapper;

    public UserUserCaseImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        userMapper.mapperFromUserUserEntity(user).persist();
    }

    @Override
    public User findById(Long id) throws CreateException {
        return userMapper.mapperFromUserUserEntity(
                (UserEntity) UserEntity.findByIdOptional(id).orElseThrow(() -> new CreateException())
        );
    }

    @Override
    public List<User> findAll() {
        return UserEntity.findAll().stream().map(
                entity -> userMapper.mapperFromUserUserEntity((UserEntity) entity)
        ).collect(Collectors.toList());
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }
}
