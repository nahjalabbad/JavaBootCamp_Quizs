package org.example.quiz2.Service;

import org.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers=new ArrayList<>();


    public ArrayList<Teacher>getTeachers(){
        return teachers;
    }

    public void addTeachers(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher teacher(int id){
        for (Teacher t:teachers){
            if (t.getId()==id){
                return t;
            }
        }
        return null;
    }

    public ArrayList<Teacher> bySalary(double salary){
        ArrayList<Teacher>getBySalary=new ArrayList<>();
        boolean noTeacher=false;
        for (Teacher t:teachers){
            if (t.getSalary()>=salary){
                getBySalary.add(t);
                noTeacher=true;
            }
        }
        if (!noTeacher){
            return null;
        }
        return getBySalary;
    }

}
