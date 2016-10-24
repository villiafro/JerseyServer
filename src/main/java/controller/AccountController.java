package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Users;
import service.AccountService;

import javax.ws.rs.*;
import java.util.ArrayList;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
@Path("/api")
public class AccountController {
    @GET
    @Path("/users")
    @Produces("application/json")
    public ArrayList<Users> getHelloWorld() throws JsonProcessingException {
        System.out.println("In the account endpoint");

        ArrayList<Users> users = AccountService.getUsers();

        return users;
    }
}
