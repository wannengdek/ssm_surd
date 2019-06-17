package hello;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class up {

   
	/**
	 * 上传单个文件操作
	 * @param RequestParam 括号中的参数名file和表单的input节点的name属性值一致
	 * @return
	 */
	@RequestMapping(value="/up", method=RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file ,Model model){
		
		System.out.println(123);
		if(!file.isEmpty()){
			try {
				//这里将上传得到的文件保存至 d:\\temp\\file 目录
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("k:\\", 
						System.currentTimeMillis()+ file.getOriginalFilename()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("message","success");
		return "test";  //上传成功则跳转至此success.jsp页面
	}
  

}


