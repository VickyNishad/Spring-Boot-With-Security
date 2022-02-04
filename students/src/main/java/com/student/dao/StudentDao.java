package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.details.StudentDetails;

public interface StudentDao extends JpaRepository<StudentDetails, Long> {
}
