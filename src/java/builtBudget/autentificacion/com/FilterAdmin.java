/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builtBudget.autentificacion.com;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andresmalagueno
 */

public class FilterAdmin implements Filter {
    

        private FilterConfig configuration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
        if (((HttpServletRequest) request).getSession().getAttribute(AutentificacionBeans.Key_usuario) == null ||
                !(((HttpServletRequest) request).getSession().getAttribute(AutentificacionBeans.Key_usuario)).equals("administrador") ) {
            ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login.faces");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.configuration = null;
    }

    
}
