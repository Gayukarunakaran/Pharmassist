package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.exceptionhandler.FieldErrorExceptionHandler;
import com.example.pharmassist.requestdtos.PharmacyRequest;
import com.example.pharmassist.responsedtos.PharmacyResponse;
import com.example.pharmassist.service.PharmacyService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;
import com.example.pharmassist.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
	
	

	@GetMapping("/admins/{adminId}/pharmacies")
	@Operation(description = "The endpoint can be used to find the pharmacy associated with the admin through admin ID",
	responses = {
			@ApiResponse(responseCode = "302",description = "Pharmacy Found"),
			@ApiResponse(responseCode = "404",description = "Pharmacy not found by ID",
			content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacyByAdminId(@PathVariable String adminId)
	{
		PharmacyResponse response=pharmacyService.findPharmacyByAdminId(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND,"Pharmacy associated with admin found",response );
	}
	
	
	
	@PutMapping("/pharmacies/{pharmacyId}")
	@Operation(description = "The endpoint can be used to update the pharmacy based on the unique ID",
	responses = {
			@ApiResponse(responseCode = "302",description = "Pharmacy Found"),
			@ApiResponse(responseCode = "400",description = "Bad Request",
			content= {
					@Content(schema= @Schema(implementation = FieldErrorExceptionHandler.class))
			}),
			@ApiResponse(responseCode = "404",description = "Pharmacy not found by ID",
			content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
})
	public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacy(@RequestBody PharmacyRequest pharmacyRequest,@PathVariable String pharmacyId)
	{
		PharmacyResponse response=pharmacyService.updatePharmacy(pharmacyRequest, pharmacyId);
		return appResponseBuilder.success(HttpStatus.OK,"Pharmacy Updated", response);
	}





}
