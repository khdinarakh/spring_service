package kz.dar.academy.backend.employeecoreapi.service;

import kz.dar.academy.backend.employeecoreapi.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getAllEmployee();

    EmployeeModel getEmployeeId(String employeeId);

    void updateEmployeeById(String employeeId, EmployeeModel employeeModel);

    void deleteEmployeeById(String employeeId);

}

