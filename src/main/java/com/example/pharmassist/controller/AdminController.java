package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;
import com.example.pharmassist.service.AdminService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;

	public AdminController(AdminService adminService,AppResponseBuilder appResponseBuilder)
	{
		this.adminService=adminService;
		this.appResponseBuilder=appResponseBuilder;
	}

	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest)
	{
		AdminResponse response=adminService.addAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED,"Admin Created", response);
	}

}
