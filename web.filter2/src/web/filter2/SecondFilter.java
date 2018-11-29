package web.filter2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				this.config = filterConfig;
				
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	System.out.println("SecondFilter: before");
		chain.doFilter(request, response);
		System.out.println("SecondFilter: after");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
