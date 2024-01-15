package kz.dar.academy.backend.employeecoreapi.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeModel {
    private String employeeId;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Name can not be empty")
    @Size(min = 2, max = 16, message = "Size must between 2 and 16")
    private String surname;
    private String company;
    private String position;
    @Email(message = "Incorrect email")
    private String email;
    private double salary;
}
