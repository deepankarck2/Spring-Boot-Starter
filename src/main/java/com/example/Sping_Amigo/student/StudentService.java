package com.example.Sping_Amigo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

        //Instead of this, use the above to fetch info form stuRepo
        //        return List.of(
        //                new Student(1L, "Mariam", "ddddddddd@dsl", LocalDate.of(2020, Month.FEBRUARY, 5), 21)
        //        );
    }

    public void addNewStudent(Student student){
         Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());

         if(studentOptional.isPresent()){
                throw new IllegalStateException("Email taken");
         }
         studentRepository.save(student);

        System.out.println(student);
    }

    public void deleteStudent(Long studentId){
            boolean exists = studentRepository.existsById(studentId);
            if(!exists){
                throw new IllegalStateException("Student with id: " + studentId + " doesn't exists");
            }
            studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, String name, String email){
        
    }
}
