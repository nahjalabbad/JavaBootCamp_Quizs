package org.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "ID cannot be empty")
    @Min(value = 2, message = "ID cannot be less than 2 ")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2,max = 20,message = "Name length between 2 and 20")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 15, message = "Age cannot be less 15 year old")
    @Max(value=60, message = "Age cannot be above 60 year old")
    private int age;

    @NotEmpty(message = "Major cannot be empty")
    @Size(min = 2,message = "Major should be at least 2 characters")
    private String major;
}
