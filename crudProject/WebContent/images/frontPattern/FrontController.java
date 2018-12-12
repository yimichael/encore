package com.encore.frontPattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.EmpVO;
import com.encore.util.EmpUtil;

/**
 *http://localhost:9090/education/emp/emplist.go 
 */
@WebServlet("*.go")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI()); //education/emp/emplist.go 
		//System.out.println(request.getContextPath()); //education
		
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String requestURI = uri.substring(path.length(), uri.length()-3);
		//System.out.println(requestURI);
		RequestDispatcher rd = null;
		response.setCharacterEncoding("utf-8");
		
		CommonController controller = null;
		Map<String, Object> data = new HashMap<>();
		String page = null;
		String method = request.getMethod().toLowerCase();
		data.put("method", method);
		
		switch (requestURI) {
		case "/emp/emplist":
			controller= new EmpListController();
			page= "emplist.jsp";
			break;
		case "/emp/empById":
			controller= new EmpUpdateController();
			if(method.equals("get")) {
				String sid = request.getParameter("empid");
				int empid = Integer.parseInt(sid);
				data.put("empid", empid);
				page = "empDetail.jsp";
			}else {
				EmpVO emp = EmpUtil.makeEmp(request);
				data.put("emp", emp);
				page = "result.jsp";
			}
			break;
		case "/emp/empInsert":
			controller= new EmpInsertController();
			if(method.equals("get")) {
				page="empInsert.jsp";
			}else {
				data.put("emp", EmpUtil.makeEmp(request));
				page = "result.jsp";
			}
			break;
		case "/emp/empDelete":
			controller= new EmpDeleteController();
			String sid = request.getParameter("empid");
			int empid = Integer.parseInt(sid);
			data.put("empid", empid);
			page="result.jsp";
			break;
			
		default:
			break;
		}
		controller.execute(data);
		for(String key: data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	 

}
