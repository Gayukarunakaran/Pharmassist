package com.example.pharmassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pharmassist.entity.Patient;
import com.example.pharmassist.entity.Pharmacy;

public interface PatientRepository extends JpaRepository<Patient,String>
{
	List<Patient> findByPharmacy(Pharmacy pharmacy);
}
