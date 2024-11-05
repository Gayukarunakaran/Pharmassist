package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassist.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
