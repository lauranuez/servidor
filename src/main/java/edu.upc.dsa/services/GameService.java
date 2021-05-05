package edu.upc.dsa.services;

import edu.upc.dsa.Classes.ObjectGame;
import edu.upc.dsa.Classes.UserGame;
import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {

    private GameManager gm;

    public GameService() {

        this.gm = GameManagerImpl.getInstance();

        if (!this.gm.isDirty()) {

            ObjectGame o1 = new ObjectGame("espada");
            ObjectGame o2 = new ObjectGame("escudo");
            ObjectGame o3 = new ObjectGame("pistola");

            UserGame u1 = new UserGame("Sara", "Rosello");
            UserGame u2 = new UserGame("Juan", "Formento");
            UserGame u3 = new UserGame("Alba", "Garcia");
            UserGame u4 = new UserGame("Fer", "Casas");

            gm.addUser(u1);
            gm.addUser(u2);
            gm.addUser(u3);
            gm.addUser(u4);

            gm.addObject(o1, "Alba");
            gm.addObject(o3, "Alba");
            gm.addObject(o2, "Alba");

            gm.dirty();
        }
    }

    @GET
    @ApiOperation(value = "get users list", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserGame.class, responseContainer="List"),
    })
    @Path("/userslist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByPrize() {

        List<UserGame> listUsers = this.gm.getUsersByName();

        GenericEntity<List<UserGame>> entity = new GenericEntity<List<UserGame>>(listUsers) {};
        return Response.status(201).entity(entity).build();

    }

    @POST
    @ApiOperation(value = "add user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= UserGame.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(UserGame u) {
        if (u.getName()==null)  return Response.status(500).entity(u).build();
        this.gm.addUser(u);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/updateUser")
    public Response updateUser(UserGame u) {

        UserGame t = this.gm.changeUser(u.getName(), u.getSurname(), u.getId());

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get objects by user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = ObjectGame.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/objects/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectsByUser(@PathParam("name") String id) {
        List<ObjectGame> listObject = gm.getObjects(id);

        if (listObject == null) return Response.status(404).build();
        else {
            GenericEntity<List<ObjectGame>> entity = new GenericEntity<List<ObjectGame>>(listObject) {};
            return Response.status(201).entity(entity).build();
        }
    }

    @POST
    @ApiOperation(value = "add object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= UserGame.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addObject/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObject(@PathParam("name") String id, ObjectGame o) {
        if (o.getName()==null)  return Response.status(500).entity(o).build();
        this.gm.addObject(o,id);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get info user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserGame.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoUser(@PathParam("name") String id) {
        UserGame u = gm.returnInfoUser(id);

        if (u == null) return Response.status(404).build();
        else {
            GenericEntity<UserGame> entity = new GenericEntity<UserGame>(u) {};
            return Response.status(201).entity(entity).build();
        }
    }




}
