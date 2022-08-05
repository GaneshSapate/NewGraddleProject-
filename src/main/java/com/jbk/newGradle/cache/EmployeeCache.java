package com.jbk.newGradle.cache;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.jbk.newGradle.dao.EmployeeDao;
import com.jbk.newGradle.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class EmployeeCache {

    @Autowired
    EmployeeDao dao;

    private HashMap<Integer, Employee> map=new HashMap<>();

    public HashMap<Integer, Employee> getMap(){
        return this.map;
    }

    @Scheduled(cron = "*/20 * * * * *")
    public void loadCache(){
        System.out.println("cache start");
        map.clear();
        List<Employee> list = dao.findAll();
        list.forEach(emp->{
            this.map.put(emp.getEid(),emp);
        });
    }
}
