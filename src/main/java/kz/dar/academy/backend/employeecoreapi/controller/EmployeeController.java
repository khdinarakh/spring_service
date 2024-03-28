package kz.dar.academy.backend.employeecoreapi.controller;


import jakarta.validation.Valid;
import kz.dar.academy.backend.employeecoreapi.model.EmployeeModel;
import kz.dar.academy.backend.employeecoreapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    private final Environment env;

    @GetMapping("/check")
    public String check() {
        return "employee-core-api is working at the port";
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        employeeService.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId){
        return employeeService.getEmployeeId(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee (@PathVariable String employeeId,
                                                  @Valid @RequestBody EmployeeModel employeeModel){

        employeeService.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }



}
