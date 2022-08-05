package com.jbk.newGradle.controller;

import com.jbk.newGradle.cache.EmployeeCache;
import com.jbk.newGradle.entity.Employee;
import com.jbk.newGradle.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    // This is the updated controller we have added to show git operations

    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeCache cache;


    //asdkasd sadasdas sadsad
    @PostMapping("/allEmployeeTest")
    public ResponseEntity<List<Employee>> getAllEmployee1(){
        //HashMap<Integer, Employee> map = cache.getMap();
        //List<Employee> list= new ArrayList<>(map.values());
        List<Employee> list=service.getAllEmployee();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        //HashMap<Integer, Employee> map = cache.getMap();
        //List<Employee> list= new ArrayList<>(map.values());
        List<Employee> list=service.getAllEmployee();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> findById(@PathVariable int id){
        Employee employee=service.findById(id);
        List<Employee> list=new ArrayList<>();
        if(employee!=null){
            list.add(employee);
            return new  ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            return new  ResponseEntity<>(list,HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp = service.addEmployee(employee);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
    @DeleteMapping("/{eid}")
    public ResponseEntity<List<String>> deleteEmployee(@PathVariable int eid){
        boolean b = service.deleteEmployee(eid);
        List<String> list=new ArrayList<>();
        if(b){
            list.add("Employee Deleted Successfully");
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            list.add("Employee not Exist");
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/{eid}")
    public ResponseEntity<List<String>> updateEmployee(@RequestBody Employee employee,@PathVariable int eid){
        boolean b = service.updateEmployee(eid, employee);
        List<String> list=new ArrayList<>();
        if(b){
            list.add("employee updated successfully");
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            list.add("Something Wrong !!!");
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
