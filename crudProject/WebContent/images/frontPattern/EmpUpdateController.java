package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;
import com.encore.model.EmpVO;

public class EmpUpdateController implements CommonController{

	@Override
	public void execute(Map<String, Object> data) {
		EmpService service = new EmpService();

		String method = (String)data.get("method");
		if(method.equals("get")) {
			int empid = (Integer)data.get("empid");
			data.put("emp", service.selectById(empid));
			//부서, 직책, 메니져 
			data.put("deptlist", service.selectAllDept());
			data.put("joblist", service.selectAllJob());
			data.put("mlist", service.selectAllManager());
		}else {
			EmpVO emp = (EmpVO)data.get("emp");
			data.put("message",service.updateEmp(emp)>0?"수정성공":"수정실패");
		}
		

		
	}

}
