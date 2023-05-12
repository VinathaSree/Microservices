package com.microservices.microservicesdemo.Service;

import com.microservices.microservicesdemo.Model.Employee;
import com.microservices.microservicesdemo.Repository.EmployeeRepository;
import com.microservices.microservicesdemo.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    List<Employee> list = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
//        if(employee.getEmployeeId() == null || employee.getEmailId() == null){
//            employee.setEmployeeId(UUID.randomUUID().toString());
//        }
//        list.add(employee);
//        return employee;
        if(employee.getEmployeeId() == null){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity) ;
        System.out.println(employeeRepository.save(employeeEntity));
        return employee;
    }

    @Override
    public List<Employee> getList() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> listOfEmployees = employeeEntityList.stream().map(employeeEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity,employee);
            return employee;
        }).collect(Collectors.toList());
        return listOfEmployees;
    }

    @Override
    public Employee getEmployeeById(String id) {
//        Employee employee = list.stream().
//                filter(employeeObj -> employeeObj.getEmployeeId().equals(id)).
//                findFirst().orElseThrow( () -> new RuntimeException("Employee doesn't exist"));
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployee(String id) {
//        Employee employee = list.stream().
//                filter(employee1 -> employee1.getEmployeeId().equals(id)).findFirst().get();
//        list.remove(employee);
        employeeRepository.deleteById(id);
        return "This employee has been removed : " + id;
    }
}
