package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.SessionPoolManager;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Esta clase maneja una lista de sesiones de B1WS que se renuevan automaticamente cuando se cumple un tiempo
 * predeterminado. La clase tiene ademas un numero máximo de sesiones, las cuales abre a medida que sea necesario
 * y cierra cuando se vencen o no se han usado en un periodo de tiempo predeterminado
 */
@Path("pool")
public class SessionPoolREST {
    @EJB
    private SessionPoolManager sessionPoolManager;

    @GET
    @Path("session/{companyName}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getSession(@PathParam("companyName") String companyName) {
        return Response.ok(new ResponseDTO(0, sessionPoolManager.getSession(companyName))).build();
    }

    @PUT
    @Path("return/{sessionid}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response returnSession(@PathParam("sessionid") String sessionId) {
        sessionPoolManager.returnSession(sessionId);
        return Response.ok(new ResponseDTO(0, "La sesión fue devuelta con éxito")).build();
    }
}
