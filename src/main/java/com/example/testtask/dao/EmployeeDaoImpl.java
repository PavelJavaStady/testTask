package com.example.testtask.dao;

import com.example.testtask.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee(first_name,last_name,department_id,job_title, gender) VALUES (?,?,?,?,?)", new Object[]{employee.getFirstName(),employee.getLastName(),employee.getDepartmentId(),employee.getJobTitle(), employee.getGender()});
    }

    @Override
    public int update(Employee employee, int employeeId) {
        return jdbcTemplate.update("UPDATE employee SET first_name=?,last_name=?,department_id=?,job_title=?, gender=? WHERE employee_id=?", new Object[]{employee.getFirstName(),employee.getLastName(),employee.getDepartmentId(),employee.getJobTitle(), employee.getGender(), employeeId});
    }

    @Override
    public int delete(int employeeId) {
        return jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", employeeId);
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<Employee>(Employee.class));

    }

    @Override
    public Employee getById(int employeeId) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id=?", new BeanPropertyRowMapper<Employee>(Employee.class), employeeId);
    }
}
