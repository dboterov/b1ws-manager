package co.manager.rest;

import co.manager.b1ws.LoginService;
import co.manager.b1ws.Logout;
import co.manager.b1ws.MsgHeader;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.IGBApplicationBean;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("session")
public class SessionREST {
    private static final Logger CONSOLE = Logger.getLogger(SessionREST.class.getSimpleName());
    @Inject
    private IGBApplicationBean appBean;

    @GET
    @Path("open/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response openSession(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando sesion de DI Server para la compañia [" + companyName + "]");
        String response = login(companyName);
        return Response.ok(new ResponseDTO(response == null ? -1 : 0, response)).build();
    }

    @PUT
    @Path("closed/{sessionid}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response closeSession(@PathParam("sessionid") String sessionId) {
        CONSOLE.log(Level.INFO, "Cerrando sesion [{0}] de DI Server", sessionId);
        String response = logout(sessionId);
        return Response.ok(new ResponseDTO(response == null ? -1 : 0, response)).build();
    }

    public String login(String companyName) {
        try {
            LoginService service = new LoginService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_LOGIN_SERVICE)));
            return service.getLoginServiceSoap12().login(
                    appBean.obtenerValorPropiedad(Constants.B1WS_DATABASE_SERVER),
                    IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_DATABASE_NAME), companyName),
                    appBean.obtenerValorPropiedad(Constants.B1WS_DATABASE_TYPE),
                    IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_COMPANY_USERNAME), companyName),
                    IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_COMPANY_PASSWORD), companyName),
                    appBean.obtenerValorPropiedad(Constants.B1WS_LANGUAGE),
                    appBean.obtenerValorPropiedad(Constants.B1WS_LICENSE_SERVER));
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server. ", e);
            return null;
        }
    }

    public String logout(String sessionId) {
        try {
            LoginService service = new LoginService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_LOGIN_SERVICE)));
            MsgHeader header = new MsgHeader();
            header.setSessionID(sessionId);
            Logout parameters = new Logout();
            service.getLoginServiceSoap12().logout(parameters, header);
            CONSOLE.log(Level.INFO, "Sesion [{0}] DI Server finalizada con exito", sessionId);
            return "Sesion DI Server finalizada con exito";
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al finalizar la sesion en el DI Server " + sessionId, e);
            return null;
        }
    }
}