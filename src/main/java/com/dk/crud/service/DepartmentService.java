package com.dk.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.crud.bean.Department;
import com.dk.crud.dao.DepartmentMapper;


@Service
public class DepartmentService
{
	@Autowired
	private DepartmentMapper departmentMapper;
	public List<Department> getDepts()
	{
		List<Department> list= departmentMapper.selectByExample(null);
		//传入null   会自动帮我们查所有的 部门
		return list;
	}
}
