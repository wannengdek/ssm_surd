package com.dk.crud.test;

import java.io.IOException;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dk.crud.bean.Department;
import com.dk.crud.bean.Employee;
import com.dk.crud.dao.DepartmentMapper;
import com.dk.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(value="classpath:applicationContext.xml")
public class MapperTest
{
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试 Depmapper的单个插入和批量插入
	 * @throws IOException 
	 */
	@Test
 	public void testInsert() throws IOException
	{
//		departmentMapper.insertSelective(new Department(null,"产品部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));	
		//单个员工插入
//		employeeMapper.insertSelective(new Employee(null,"tom","M","jery12@qq.com",2));
//		System.out.println("插入成功");
		//批量插入员工       使用可以批量执行的sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(1);
		System.out.println(departmentMapper);
		for(int i = 0;i<100;i++){
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid, "M", uid+"@atguigu.com", 1));
		}
		System.out.println("批量完成");
	}
	/**
	 * 进行查询操作
	 */
	@Test
	public void testSelect()
	{
		System.out.println("开始");
		//Employee employee = employeeMapper.selectByPrimaryKey(99);
		Employee employee = employeeMapper.selectByPrimaryKeyWithDept(2);
		System.out.println(employee);
		System.out.println("完成");
	}
	/**
	 * 进行删除操作
	 */
	@Test
	public void testDelet()
	{
		System.out.println("开始");
		int employee = employeeMapper.deleteByPrimaryKey(99);
		System.out.println(employee);
		System.out.println("完成");
	}
	/**
	 * 进行更新操作
	 */
	@Test
	public void testUpdate()
	{
		System.out.println("开始");
		//Employee employee = employeeMapper.u(2);
		
		System.out.println("完成");
	}
	
	
	
}









