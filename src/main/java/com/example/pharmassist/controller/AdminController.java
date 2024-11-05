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
import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;
import com.example.pharmassist.service.AdminService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;
import com.example.pharmassist.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
	
	
	@GetMapping("/admins/{adminId}")
	@Operation(description = "The endpoint can be used to find the admin based on the unique ID",
	responses = {
			@ApiResponse(responseCode = "302",description = "Admin Found"),
			@ApiResponse(responseCode = "404",description = "Admin not found by ID",
			content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
    })
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable String adminId)
	{
		AdminResponse adminResponse=adminService.findAdmin(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND,"Admin is found",adminResponse);
	}
	
	
	@PutMapping("/admins/{adminId}")
	@Operation(description = "The endpoint can be used to update the admin based on the unique ID",
	responses = {
			@ApiResponse(responseCode = "302",description = "Admin Found"),
			@ApiResponse(responseCode = "400",description = "Bad Request",
			content= {
					@Content(schema= @Schema(implementation = FieldErrorExceptionHandler.class))
			}),
			@ApiResponse(responseCode = "404",description = "Admin not found by ID",
			content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
    })
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String adminId)
	{
		AdminResponse adminResponse= adminService.updateAdmin(adminRequest, adminId);
		return appResponseBuilder.success(HttpStatus.OK,"Admin Updated", adminResponse);
	}


}
