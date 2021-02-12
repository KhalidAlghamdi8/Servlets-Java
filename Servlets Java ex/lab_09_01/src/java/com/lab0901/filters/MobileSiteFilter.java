/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab0901.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;



@WebFilter (filterName = "MobileSiteFilter", servletNames ={"DetailServlet", "ListServlet"})
public class MobileSiteFilter implements Filter {
    
static final Logger logger = Logger.getLogger(MobileSiteFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
logger.log(Level.INFO, "Before do");
        chain.doFilter(request, response);
        logger.log(Level.INFO, "After do");

    if (request instanceof HttpServletRequest){
        logger.log(Level.INFO, "inside the if condition");

            HttpServletRequest httpRequest = (HttpServletRequest) request; 
            String contextPath = httpRequest.getContextPath();
            String requestURL = httpRequest.getRequestURI();
            String path = requestURL.substring(contextPath.length());
            setMobileIfAvailable(httpRequest);
            String viewPath = (isMobile(httpRequest) ? "/mobile":"/desktop" )+ path + ".jsp";
            logger.log(Level.INFO,"viewpath : "+viewPath);
            try {
            request.getRequestDispatcher(viewPath).forward(request, response);
            }catch (Exception e){
            e.printStackTrace();
            }
    }
    }

    private void setMobileIfAvailable(HttpServletRequest httpRequest){
    String siteMode = httpRequest.getParameter("siteMode");
    if (siteMode != null){
    boolean isMobile = siteMode.equals("mobile");
    httpRequest.getSession().setAttribute("mobileEnabled", isMobile);
    }
    }
    private boolean isMobile(HttpServletRequest httpRequest) {
        Boolean mobileEnabled;
        mobileEnabled = (Boolean) httpRequest.getSession().getAttribute("mobileEnabled");
        if (mobileEnabled != null) {
            return mobileEnabled;
        }
        String agentHeader = httpRequest.getHeader("User-Agent");
        return agentHeader != null && agentHeader.toLowerCase().contains("mobile");

    }
    
    @Override
    public void init (FilterConfig filterConfig){}
    
    
    @Override
    public void destroy() {}
}
