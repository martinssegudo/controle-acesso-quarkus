package br.com.quarkus.api;


import br.com.quarkus.api.dtos.UserDTO;
import br.com.quarkus.mappers.UserMapper;
import br.com.quarkus.userCase.UserUserCase;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserApi {


    public UserMapper userMapper;
    public UserUserCase userCase;

    @Inject
    public UserApi(UserMapper userMapper,
                   UserUserCase userCase){
        this.userMapper = userMapper;
        this.userCase = userCase;
    }



    @POST
    @Transactional
    public Response saveUser(@RequestBody UserDTO userDTO){
        userCase.save(userMapper.mapperFromUserDTO(userDTO));
        return Response.status(HttpResponseStatus.CREATED.code()).build();
    }

    @GET
    @Path("/{userName}")
    public Response getUserByUserName(@PathParam("userName") String userName){
        return Response.ok().build();
    }

    @GET
    public Response findAll(){
        List<UserDTO> dtos = userMapper.mapperFromListUser(userCase.findAll());
        return Response.ok(dtos).build();
    }

}
