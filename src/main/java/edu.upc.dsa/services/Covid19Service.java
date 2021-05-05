package edu.upc.dsa.services;


import edu.upc.dsa.Classes.*;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/covid19", description = "Endpoint to Covid19 Service")
@Path("/covid19")

public class Covid19Service {
    private Covid19Manager cm;

    public Covid19Service() {

        this.cm = Covid19ManagerImp.getInstance();
        if (!this.cm.isDirty() ) {

            UserCovid u1 = new UserCovid("Maria", "Casas", 40, "B",1);
            UserCovid u2 = new UserCovid("Juan", "Mateo", 20, "A",2);
            UserCovid u3 = new UserCovid("Francisco", "Peralta", 80, "D",3);

            cm.addUser(u1);
            cm.addUser(u2);
            cm.addUser(u3);

            Laboratorio l1 = new Laboratorio(1, "Barcelona");
            Laboratorio l2 = new Laboratorio(2, "Gava");

            cm.addLab(l1);
            cm.addLab(l2);

            Muestra m1 = new Muestra("1254d", 123222, "Juan","Barcelona", "2021-02-02");
            Muestra m2 = new Muestra("4445f", 123222, "Francisco","Gava", "2021-03-08");
            Muestra m3 = new Muestra("6754g", 123222, "Maria","Gava", "2021-04-22");

            cm.ExtraerMuestra(m1);
            cm.ExtraerMuestra(m2);
            cm.ExtraerMuestra(m3);
            cm.dirty();
        }


    }

    @GET
    @ApiOperation(value = "get muestras by user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No hay muestras procesadas")
    })
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMuestrasByUser(@PathParam("name") String id) {
        List<Muestra> listMuestra = cm.MuestrasProcesadasUsuario(id);

        if (listMuestra.size() == 0) return Response.status(404).build();
        else {
            GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(listMuestra) {};
            return Response.status(201).entity(entity).build();
        }
    }
    @POST
    @ApiOperation(value = "create a new user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=UserCovid.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/newUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(UserCovid u) {
        if (u.getName()==null)  return Response.status(500).entity(u).build();
        this.cm.addUser(u);
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "create a new muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Muestra.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/newMuestra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuestra(Muestra m) {
        if (m.getName()==null)  return Response.status(500).entity(m).build();
        this.cm.ExtraerMuestra(m);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "process muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Muestra.class),
            @ApiResponse(code = 404, message = "No muestras to process!!")
    })
    @Path("/processMuestra/{lab}")
    public Response ProcessMuestra(@PathParam("lab") int lab) {
        Muestra m = this.cm.ProcesarMuestra(lab);
        if (m == null) return Response.status(404).build();
        else {
            GenericEntity<Muestra> entity = new GenericEntity<Muestra>(m) {};
            return Response.status(201).entity(entity).build();
        }
    }
    @POST
    @ApiOperation(value = "create a new lab", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Laboratorio.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/newLab")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newLab(Laboratorio l) {
        if (l.getName()==null)  return Response.status(500).entity(l).build();
        this.cm.addLab(l);
        return Response.status(201).build();
    }

}
