package com.example.Sping_Amigo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Select * FROM student where email=<email>;
    @Query("SELECT s FROM Student s WHERE s.email = ?1") //the student here is the class student, not table.
    Optional<Student> findStudentByEmail(String email);
}
