package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;
import com.encore.model.EmpVO;

public class EmpInsertController implements CommonController{

	@Override
	public void execute(Map<String, Object> data) {
		EmpService service = new EmpService();
		String method = (String)data.get("method");
		if(method.equals("get")) {
			data.put("deptlist", service.selectAllDept());
			data.put("joblist", service.selectAllJob());
			data.put("mlist", service.selectAllManager());
		}else {
		EmpVO emp = (EmpVO)data.get("emp");
		data.put("message", service.insertEmp(emp)>0?"입력성공":"입력실패");
		}
	}

}
