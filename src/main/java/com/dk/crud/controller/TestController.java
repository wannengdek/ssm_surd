package com.dk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.crud.bean.Employee;
import com.dk.crud.bean.Msg;
import com.dk.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TestController {

    /**
     *
     * @RequestMapping 表示只要是/hello.action的请求，就交由该方法处理。当然了.action可以去掉
     * @param model 它和ModelAndView类似，它这个Model就是把数据封装到request对象中，我们就可以获取出来
     * @return 返回跳转的页面【真实路径，就不用配置视图解析器了】
     * @throws Exception
     */
    @RequestMapping("/hello")

    public String hello(Model model) throws Exception{
        System.out.println("HelloAction::hello()");
        model.addAttribute("message","你好");
        return "upload";
    }
    @RequestMapping(value = "/hello.action")
    public String hello(Model model, String username, int id) throws Exception {
        System.out.println("用户名是：" + username);
        System.out.println("编号是：" + id);
        if (username.equals("123"))
		{model.addAttribute("message", "你好");
        	  return "test";
		}
        else
        {
        	model.addAttribute("message", "buhao");
      	  return "test";
        }
        
    }
}


