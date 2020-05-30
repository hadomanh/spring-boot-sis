package hust.hadm.repository;

import org.springframework.stereotype.Repository;

import hust.hadm.entity.Student;

@Repository
public interface StudentRepository extends MainRepository<Student> {

}
