package com.ryazanova.MyApplicationH2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ryazanova.MyApplicationH2.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
