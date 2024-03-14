package org.example.quiz2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.API.ApiResponse;
import org.example.quiz2.Model.Teacher;
import org.example.quiz2.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeachers(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeachers(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher has been added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeachers(@PathVariable int id, @RequestBody @Valid Teacher teacher, Errors errors){
        boolean isUpdated=teacherService.updateTeacher(id,teacher);
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (isUpdated){
            return ResponseEntity.ok().body(new ApiResponse("Teacher has been updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeachers(@PathVariable int id){
        boolean isDeleted=teacherService.deleteTeacher(id);
        if (isDeleted){
            return ResponseEntity.ok().body(new ApiResponse("Teacher has been deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity teacher(@PathVariable int id){
        Teacher teacher=teacherService.teacher(id);
        if (teacher==null){
            return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
        }
        return ResponseEntity.status(200).body(teacher);
    }


    @GetMapping("/bysalary/{salary}")
    public ResponseEntity bySalary(@PathVariable double salary){
        ArrayList<Teacher> getBySalary=teacherService.bySalary(salary);
        if (getBySalary==null){
            return ResponseEntity.status(400).body(new ApiResponse("no teachers with this salary were found"));
        }
        return ResponseEntity.status(200).body(getBySalary);
    }


}
