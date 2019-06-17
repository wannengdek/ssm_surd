package com.dk.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dk.crud.bean.Employee;
import com.github.pagehelper.PageInfo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest
{
	//传入springmvc 的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟请求  模仿测试
	MockMvc mockMvc;
	@Before
	public void initMockMvc()
	{
		 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception
	{
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		//请求成功之后  请求域会有pageInfo 取出pageInfo 进行验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码"+pi.getPageNum());
		System.out.println("总记录数"+pi.getTotal());
		System.out.println("连续显示的页码是");
		int[] navigatepageNums = pi.getNavigatepageNums();
		for (int i :navigatepageNums)
		{
			System.out.println(" "+i);
		}
		//获取员工数据
		List<Employee> list = pi.getList();
		for (Employee employee : list)
		{
			System.out.println("id:"+employee.getEmpId());
			System.out.println("name:"+employee.getEmpName());
		}
	}
}
