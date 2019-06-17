<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}<br/>

    <form action="upload.action" method="post" enctype="multipart/form-data">
		<label>用户名：</label><input type="text" name="username"><br>
		<label>密码：</label><input type="password" name="password"><br>
		<label>上传头像：</label><input type="file" name="file"><br>
		<input type="submit">
	</form>
	
	<a href="download.action">下载指定文件</a>
	  
	  
	  
	  
<form action="${pageContext.request.contextPath}/hello.action" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>编号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
	  

</body>
</html>