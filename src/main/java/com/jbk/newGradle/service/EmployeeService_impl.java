package com.jbk.newGradle.service;

import com.jbk.newGradle.dao.EmployeeDao;
import com.jbk.newGradle.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService_impl implements EmployeeService{

    @Autowired
    EmployeeDao dao;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp = dao.save(employee);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> list = dao.findAll();
        return list;
    }

    @Override
    public boolean updateEmployee(int eid,Employee employee) {
        boolean b= false;
        Optional<Employee> emp = dao.findById(employee.getEid());
        if(emp.isPresent()){
            Employee e = emp.get();
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setSalary(employee.getSalary());
            dao.save(e);
            b=true;
        }
        else {
            b=false;
        }
        return b;
    }

    @Override
    public boolean deleteEmployee(int eid) {
        boolean b=false;
        Optional<Employee> emp = dao.findById(eid);
        if(emp.isPresent()) {
            dao.deleteById(eid);
            b = true;
        }

        return b;
    }

    @Override
    public Employee findById(int eid) {
        Optional<Employee> employee = dao.findById(eid);
        if(!employee.isEmpty()){
            return employee.get();
        }
        else {
            return null;
        }

    }
}
