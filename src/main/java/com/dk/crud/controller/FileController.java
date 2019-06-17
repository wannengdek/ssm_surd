package com.dk.crud.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

    /**
     * 单个文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file")MultipartFile file){
    	System.out.println(123);
        if (!file.isEmpty()){
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("k:\\",
                        System.currentTimeMillis()+ file.getOriginalFilename()));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        //上传成功，跳转至success页面
        return "test";
    }
   
    /**
     * 指定文件下载
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "download",produces = "application/octet-stream;charset=UTF-8")
    public ResponseEntity<byte[]> download() throws IOException {
//                指定文件,必须是绝对路径
        File file = new File("k:\\tmp.txt");
//                下载浏览器响应的那个文件名
        String dfileName = "tmp.txt";
//                下面开始设置HttpHeaders,使得浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
//                设置响应方式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                设置响应文件
        headers.setContentDispositionFormData("attachment", dfileName);
//                把文件以二进制形式写回
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}


