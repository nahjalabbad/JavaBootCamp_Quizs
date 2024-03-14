package org.example.quiz2.Service;

import org.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public boolean updateStudents(int id, Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id) {
                students.remove(i);
                return true;
            }
            }
        return false;
        }

        public Student student(String name){
        for (Student s:students){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> byMajor(String major){
        ArrayList<Student> getByMajor=new ArrayList<>();
        boolean found = false;
        for (Student s:students){
            if (s.getMajor().equalsIgnoreCase(major)){
                getByMajor.add(s);
                found=true;
            }
        }
        if (!found){
            return null;
        }
        return getByMajor;
    }
}
