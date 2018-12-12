package com.encore.util;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.encore.model.EmpVO;

public class EmpUtil {
	public static EmpVO makeEmp(HttpServletRequest request) {
		String sempid= request.getParameter("employee_id");
		int employee_id = Integer.parseInt(sempid);
		String first_name= request.getParameter("first_name");
		String last_name= request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		String ssalary = request.getParameter("salary");
		int salary = Integer.parseInt(ssalary);
		String scomm = request.getParameter("commission_pct");
		double commission_pct = Double.parseDouble(scomm);
		String smanager_id=request.getParameter("manager_id");
		int manager_id = Integer.parseInt(smanager_id);
		String sdepartment_id = request.getParameter("department_id");
		int department_id=Integer.parseInt(sdepartment_id);
		String shire_date = request.getParameter("hire_date");
		//String ->java.sql.Date
		Date hire_date = DateUtil.stringToDate(shire_date);
		EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
		System.out.println(emp);
		return emp;
	}

}
