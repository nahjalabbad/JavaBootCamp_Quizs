package org.example.quiz2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.API.ApiResponse;
import org.example.quiz2.Model.Student;
import org.example.quiz2.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudents(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.ok().body(new ApiResponse("Student has been added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudents(@PathVariable int id, @RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= studentService.updateStudents(id,student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student has been updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudents(@PathVariable int id){
        boolean isDeleted=studentService.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student has been deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/student/{name}")
    public ResponseEntity student(@PathVariable String name){
        Student student=studentService.student(name);
        if (student==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student with the name "+name+" not found"));
        }
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/bymajor/{major}")
    public ResponseEntity byMajor(@PathVariable String major){
        ArrayList<Student> getByMajor=studentService.byMajor(major);

        if (getByMajor==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student with this major "+major+" not found"));
        }
        return ResponseEntity.status(200).body(getByMajor);
    }
}
