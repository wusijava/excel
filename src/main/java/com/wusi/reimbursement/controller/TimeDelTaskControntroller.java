package com.wusi.reimbursement.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class TimeDelTaskControntroller {

    @RequestMapping("timeTask")
    @Scheduled(cron = "0 0 12 * * ?")
    public void timetask() {
        long keepDays=7;
        String servePath="/home/excel";
        File file= new File(servePath);
        File[] files=file.listFiles();
        for (File fileList:files) {
            long filetime = fileList.lastModified();
            long now=System.currentTimeMillis();
            long day=(now-filetime)/(1000*24*3600);
            if(day>keepDays){
                fileList.delete();
            }
        }
    }

}
