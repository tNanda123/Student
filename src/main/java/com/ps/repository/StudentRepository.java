package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.Entity.student;

public interface StudentRepository extends JpaRepository<student,Integer>{

}
