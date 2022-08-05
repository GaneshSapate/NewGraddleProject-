package com.jbk.newGradle.service;

import com.jbk.newGradle.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public boolean updateEmployee(int eid,Employee employee);
    public boolean deleteEmployee(int eid);
    public Employee findById(int eid);
}
