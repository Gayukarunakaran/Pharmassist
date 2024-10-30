package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> 
{

}
