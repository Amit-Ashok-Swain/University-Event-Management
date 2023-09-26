package com.geekster.project.assignment.UniversityEventManagement.Service;

import com.geekster.project.assignment.UniversityEventManagement.Model.Department;
import com.geekster.project.assignment.UniversityEventManagement.Model.Student;
import com.geekster.project.assignment.UniversityEventManagement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    public String addAStudent(Student s){
        studentRepo.save(s);
        return "A student is added !!!";
    }

    public String addStudents(List<Student> s){
        studentRepo.saveAll(s);
        return "List of students are added !!!";
    }

    public Iterable<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Integer id){
        return studentRepo.findById(id);
    }

    public  String updateStudentDepartment(Integer id, Department department){
        Optional<Student> s = studentRepo.findById(id);

        if(s.isEmpty()){
            return "Student Id not found !!!";
        }

        Student stu = s.get();
        stu.setStudentDepartment(department);
        studentRepo.save(stu);
        return "Student's Department is Updated !!!";
    }

    public String removeStudentById(Integer id){

        Student stu = studentRepo.findById(id).orElse(null);

        if(stu==null){
            return "Student's Id not found";
        }

        studentRepo.delete(stu);

        return "Student is Removed";
    }

}
