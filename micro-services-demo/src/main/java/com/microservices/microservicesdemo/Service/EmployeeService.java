package com.microservices.microservicesdemo.Service;

import com.microservices.microservicesdemo.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getList();

    Employee getEmployeeById(String id);

    String deleteEmployee(String id);
}
