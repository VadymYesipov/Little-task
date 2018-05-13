package com.aimprosoft.yesipov.db.dao;

import com.aimprosoft.yesipov.db.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    void editEmployee(Employee employee, String query);

    void removeEmployee(Employee employee, int size);

    List<Employee> employeeList();

    List<Employee> filteredEmployeeList(Integer id);
}
