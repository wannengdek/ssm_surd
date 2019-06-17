package com.dk.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.crud.bean.DepartmentExample.Criteria;
import com.dk.crud.bean.Employee;
import com.dk.crud.bean.EmployeeExample;
import com.dk.crud.dao.EmployeeMapper;


@Service
public class EmployeeService
{
	@Autowired
	EmployeeMapper employeeMapper;
	public List<Employee> getAll()
	{
		/**
		 * 查询所有员工
		 */
		return employeeMapper.selectByExampleWithDept(null);
	}
	public void saveEmp(Employee employee)
	{
		/**
		 * 插入员工
		 * 不需要返回操作
		 */
		 employeeMapper.insertSelective(employee);
	}
	
	public boolean checkUser(String empName)
	{
		/**
		 * true  可用
		 *  
		 */
		EmployeeExample example = new EmployeeExample();
		com.dk.crud.bean.EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}
	public void deleteBatch(List<Integer> del_ids)
	{
		EmployeeExample example = new EmployeeExample();
		com.dk.crud.bean.EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}
	public void updateEmp(Employee employee)
	{
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	public Employee getEmp(Integer id)
	{
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
	public void deleteEmp(Integer id)
	{
		employeeMapper.deleteByPrimaryKey(id);
	}
	
}
