package com.encore.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncordingFilter
 */
@WebFilter("*.do")  
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
    	System.out.println("MyFilter 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("MyFilter 소멸");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
			System.out.println("MyFilter 요청 실행 전");
			request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("MyFilter 요청 실행 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter 초기화");
	}

}
