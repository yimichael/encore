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
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		
		if(requestURI.equals("/login/signOut")) {
			session.invalidate();
			response.sendRedirect("../index.jsp");
			return;
		}
		
		
		Object sessionObj =session.getAttribute("emp");
		if(!requestURI.equals("/login/sign") && sessionObj==null) {
			response.sendRedirect(path+"/login/sign.go");
			return;
		}
		
			
		switch (requestURI) {
		
		case "/emp/getEmpInfo":
			controller = new EmpUpdateController();
			int empid2 = Integer.parseInt(request.getParameter("empid"));
			data.put("empid", empid2);
			page="result2.jsp";
			break;
			
		case "/emp/managerlist":
			controller=new ManagerController();
			page = "managerlist.jsp";
			break;
		
		case "/emp/joblist":
			controller=new JobController();
			page = "joblist.jsp";
			break;
			
		case "/emp/deptlist":
			controller=new DeptController();
			page = "deptlist.jsp";
			break;
			
		case "/login/sign":
			controller = new LoginContorller();
			if(method.equals("get")) {
				page="sign.jsp";
			}else {
				String userid = request.getParameter("userid"); //first_name
				String userpass = request.getParameter("userpass"); //last_name
				data.put("userid", userid);
				data.put("userpass", userpass);
			}
			break;

		case "/emp/emplist":
			controller= new EmpListController();
			page= "emplist.jsp";
			break;
			
		case "/emp/emplist2":
			controller= new EmpListController2();
			data.put("deptid", request.getParameter("deptid"));
			data.put("jobid", request.getParameter("jobid"));
			data.put("salary", request.getParameter("salary"));
			page= "emplist2.jsp";
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
		
		Object result = data.get("loginResult"); //로그인인 경우, 기타
		if(result != null) {
			String yesNo = (String)result;
			if(yesNo.equals("yes")) {
				//인증되면 index.jsp
				//HttpSession session = request.getSession();
				EmpVO emp = (EmpVO)data.get("emp");
				session.setAttribute("emp", emp);
				response.sendRedirect("../index.jsp");
				return;
			}else {
				//인증안되면 sign.jsp
				session.setAttribute("", "인증실패");
				response.sendRedirect("sign.go");
				return;
			}
		}
		
		for(String key: data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	 
}
