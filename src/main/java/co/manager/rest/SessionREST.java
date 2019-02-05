package co.manager.rest;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("session")
public class SessionREST {
    private static final Logger CONSOLE = Logger.getLogger(SessionREST.class.getSimpleName());

    @GET
    @Path("open/{usurname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getSession(@PathParam("usurname") String usurName) {
        CONSOLE.log(Level.INFO, "Iniciando sesion para el usuario [" + usurName + "]");
        return null;
    }

    @PUT
    @Path("closed")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response closeSession() {
        CONSOLE.log(Level.INFO, "Cerrando sesion");

        return null;
    }
}
