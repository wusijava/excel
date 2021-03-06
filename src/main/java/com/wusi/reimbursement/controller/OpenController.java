package com.wusi.reimbursement.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ Description   :  附件下载controller
 * @ Author        :  wusi
 * @ CreateDate    :  2020/1/15$ 17:28$
 */
@RestController
@RequestMapping(value = "/api/open/")
public class OpenController {
    @GetMapping(value = "/downloadExcel/{filename}")
    @ResponseBody
    public void fileDownLoad(HttpServletResponse response,@PathVariable(value = "filename")String filename) throws IOException {
        //System.out.println(filename);
        File file = new File("/home/excel/"+filename+".xlsx");
        String fileName = file.getName();
        //System.out.println("_________________________"+fileName);
        //InputStream ins = new FileInputStream(file);
        InputStream fis=new BufferedInputStream(new FileInputStream(file));
        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
       // response.setContentType("application/msword;charset=utf-8");
        response.setContentType("application/x-xls;charset=utf-8");
        /* 设置文件头：最后一个参数是设置下载文件名 */
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        response.setCharacterEncoding("utf-8");

        //如果有新的下载 更新此文件的最后更改时间为此刻
        file.setLastModified(System.currentTimeMillis());
        try{
            byte[] b = new byte[fis.available()];
            fis.read(b);
            OutputStream out = response.getOutputStream();
            out.write(b);
            out.flush();
            fis.close();
            out.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
