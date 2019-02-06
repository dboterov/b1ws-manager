package co.manager.rest;

import co.manager.ejb.IGBApplicationBean;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@WebFilter("/res/*")
public class HeaderDecorationFilter implements Filter {

    private static final Logger CONSOLE = Logger.getLogger(HeaderDecorationFilter.class.getSimpleName());
    private static final String ALLOWED_HEADERS = "Origin, X-Requested-With, Content-Type, Accept, X-Company-Name, Authorization, X-Employee, X-Warehouse-Code, X-Pruebas";
    private static final String ALLOWED_METHODS = "GET, OPTIONS, POST, PUT, DELETE";

    @Inject
    private IGBApplicationBean appBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", ALLOWED_HEADERS);
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", ALLOWED_METHODS);
        ((HttpServletResponse) response).addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        ((HttpServletResponse) response).addHeader("Pragma", "no-cache");
        ((HttpServletResponse) response).addHeader("Expires", "0");

        HttpServletRequest req = (HttpServletRequest) request;
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}