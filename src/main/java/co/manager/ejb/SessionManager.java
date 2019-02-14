package co.manager.ejb;

import co.manager.b1ws.LoginService;
import co.manager.b1ws.Logout;
import co.manager.b1ws.MsgHeader;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class SessionManager {

    private static final Logger CONSOLE = Logger.getLogger(SessionManager.class.getSimpleName());

    private LoginService service;

    @Inject
    private IGBApplicationBean appBean;

    public SessionManager() {
        try {
            service = new LoginService(
                    new URL(String.format(
                            appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_LOGIN_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de LoginService. ", e);
        }
    }

    public String login(String companyName) {
        try {
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
            MsgHeader header = new MsgHeader();
            header.setSessionID(sessionId);
            Logout parameters = new Logout();
            service.getLoginServiceSoap12().logout(parameters, header);
            CONSOLE.log(Level.INFO, "Sesion [{0}] DI Server finalizada con exito", sessionId);
            return "success";
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al finalizar la sesion en el DI Server " + sessionId, e);
            return "error";
        }
    }
}
