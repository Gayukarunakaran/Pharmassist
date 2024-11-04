package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.requestdtos.PharmacyRequest;
import com.example.pharmassist.responsedtos.PharmacyResponse;
import com.example.pharmassist.service.PharmacyService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PharmacyController 
{
	private final PharmacyService pharmacyService;
	private final AppResponseBuilder appResponseBuilder;

	public PharmacyController(PharmacyService pharmacyService,AppResponseBuilder appResponseBuilder)
	{
		this.pharmacyService=pharmacyService;
		this.appResponseBuilder=appResponseBuilder;
	}

	@PostMapping("/admins/{adminId}/pharmacies")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> addPharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String adminId )
	{
		PharmacyResponse response=pharmacyService.addPharmacy(pharmacyRequest,adminId);
		return appResponseBuilder.success(HttpStatus.CREATED, "Pharmacy Created", response);
	}




}
