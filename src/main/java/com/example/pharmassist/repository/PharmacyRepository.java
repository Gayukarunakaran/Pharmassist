package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
