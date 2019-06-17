package com.dk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.crud.bean.Department;
import com.dk.crud.bean.Msg;
import com.dk.crud.service.DepartmentService;

/**
 * 控制和部门有关的请求
 * @author 万能的k
 *
 */

@Controller
public class DepartmentController
{
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 返回所有部分信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts()
	{
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts",list);
	}
}
