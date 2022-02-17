package com.example.testtask.rest;

import com.example.testtask.dao.EmployeeDao;
import com.example.testtask.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao eDAO;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return eDAO.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return eDAO.getById(id);
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return eDAO.save(employee) + " saved to database";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return eDAO.update(employee, id) + " employee updated";
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return eDAO.delete(id) + " was deleted";
    }
}
