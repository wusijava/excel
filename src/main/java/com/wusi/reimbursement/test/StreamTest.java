package com.wusi.reimbursement.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StreamTest {
@Test
public  void test(){
    {
        try {
            InputStream is = new FileInputStream("D:/test.txt");
            int i =is.available();
            int n=is.read();
            System.out.println(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    @Test
    public void test2() throws IOException {
    String str="你是我情深似海的依赖！";
    OutputStream os= new FileOutputStream("D://test.txt",true);
    DataOutputStream dos=new DataOutputStream(os);
    dos.writeBytes(str);
    //os.write(str.getBytes());
}

    @Test
    public  void test3(){
        File file= new File("D:\\test");
        File[] files=file.listFiles();
        for (File fileList:files) {
            long filetime = fileList.lastModified();
            long now=System.currentTimeMillis();
            long day=(now-filetime)/(1000*24*3600);
            if(day>7){
                fileList.delete();
            }
        }
    }
}
