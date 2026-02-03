package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.getAllEmployees();
    }
    
    @GetMapping("/employee/(id)")
    public Employee getEmployee(@PathVariable int id) {
    	return employeeDao.getEmployeeById(id);
    }
    
    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee emp) {
    	System.out.println("Post Method Received from Request Body");
    	System.out.println(emp.getId()+" - "+emp.getName() + "- "+emp.getSalary());
    	employeeDao.addEmployee(emp);
    	return "Employee Added successfully";
    }
}
