package com.proiectpad2;
import org.springframework.web.filter.GenericFilterBean;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends GenericFilterBean implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Authorization", "*");


        httpResponse.setHeader("Access-Control-Allow-Headers", "*");


        httpResponse.setHeader("Access-Control-Allow-Credentials", "false");

        chain.doFilter(request, response);
    }
}