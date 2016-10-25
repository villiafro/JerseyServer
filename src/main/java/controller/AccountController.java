package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.tools.javac.main.Main;
import models.Users;
import org.glassfish.grizzly.Result;
import service.AccountService;
import service.AppDataContext;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;
import java.util.ArrayList;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
@Path("/api")
public class AccountController{
    AccountService AcService;

    public AccountController(){
        AcService = new AccountService();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersInDB() throws JsonProcessingException {
        return Response.ok(AcService.getUsers()).build();
    }
}
