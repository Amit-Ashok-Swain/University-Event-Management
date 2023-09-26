package com.geekster.project.assignment.UniversityEventManagement.Repository;

import com.geekster.project.assignment.UniversityEventManagement.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer> {
}
