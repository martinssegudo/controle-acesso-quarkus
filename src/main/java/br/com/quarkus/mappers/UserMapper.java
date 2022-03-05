package br.com.quarkus.mappers;

import br.com.quarkus.api.dtos.UserDTO;
import br.com.quarkus.bd.UserEntity;
import br.com.quarkus.userCase.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserEntity mapperFromUserUserEntity(User user);
    User mapperFromUserUserEntity(UserEntity userEntity);
    UserDTO mapperFromUser(User user);

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "bithday", target = "bithday")
    User mapperFromUserDTO(UserDTO userDTO);


    List<UserDTO> mapperFromListUser(List<User> users);
}
