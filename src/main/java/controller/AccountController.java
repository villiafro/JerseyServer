package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.HelloWorldModel;
import models.Users;
import service.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
@Path("/api")
public class AccountController extends AppDataContext{
    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHelloWorld() throws JsonProcessingException {

        ArrayList<Users> users = getUsers();

        return Response.ok(users).build();
    }
}
