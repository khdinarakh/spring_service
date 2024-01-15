package kz.dar.academy.backend.employeecoreapi.service;

import kz.dar.academy.backend.employeecoreapi.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final HashMap<String, EmployeeModel> employeeMap = new HashMap<>();

    static {
        EmployeeModel employeeModel = new EmployeeModel(UUID.randomUUID().toString(), "Aqzer", "Petrov", "DAR", "Engineer", "petrov@gmail.com",2000);
        EmployeeModel employeeModel1 = new EmployeeModel(UUID.randomUUID().toString(), "Shaparat", "Petrov", "DAR", "Engineer", "petrov@gmail.com",2000);

        EmployeeModel employeeModel2 = new EmployeeModel(UUID.randomUUID().toString(), "Ivan", "Petrov", "DAR", "Engineer", "petrov@gmail.com",2000);

        employeeMap.put(employeeModel.getEmployeeId(), employeeModel);
        employeeMap.put(employeeModel1.getEmployeeId(), employeeModel1);
        employeeMap.put(employeeModel2.getEmployeeId(), employeeModel2);
    }

    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(UUID.randomUUID().toString());
        employeeMap.put(employeeModel.getEmployeeId(), employeeModel);

    }

    @Override
    public List<EmployeeModel> getAllEmployee() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public EmployeeModel getEmployeeId(String employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void updateEmployeeById(String employeeId, EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(employeeId);
        employeeMap.put(employeeId, employeeModel);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeMap.remove(employeeId);
    }
}
