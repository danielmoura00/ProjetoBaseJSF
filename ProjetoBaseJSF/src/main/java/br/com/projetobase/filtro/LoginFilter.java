package br.com.projetobase.filtro;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetobase.sessao.DadosDaSessao;

public class LoginFilter implements Filter {

	private static final String PAGINAS_LOGIN = "/singin.jsf";
	
	@Inject
	private DadosDaSessao dadosDaSessao;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
        if (dadosDaSessao.getUsuarioDaSessao() != null) {  
            chain.doFilter(request, response);  
        } else {  
            HttpServletRequest servletRequest = (HttpServletRequest) request;
        	String contextPath = servletRequest.getContextPath();	
            HttpServletResponse servletResponse = (HttpServletResponse) response;  
            servletResponse.sendRedirect(contextPath + PAGINAS_LOGIN);  
        }  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
