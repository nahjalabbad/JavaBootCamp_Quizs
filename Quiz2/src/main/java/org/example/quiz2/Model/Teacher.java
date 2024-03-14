package org.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "ID cannot be empty")
    @Min(value = 2, message = "ID cannot be less than 2 ")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2,max = 20,message = "Name length between 2 and 20")
    private String name;

    @NotNull(message = "Salary cannot be empty")
    @PositiveOrZero(message = "Salary cannot be negative")
    @Min(value = 4000,message = "Salary cannot be less than 4000")
    private double salary;
}
