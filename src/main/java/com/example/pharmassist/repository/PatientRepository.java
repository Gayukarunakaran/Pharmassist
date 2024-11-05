package com.example.pharmassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pharmassist.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,String>
{
	@Query("SELECT p FROM Patient p JOIN p.pharmacy ph WHERE ph.pharmacyId= :pharmacyId")
	List<Patient> findPatientByPharmacyId(String pharmacyId);
}
