package com.example.pharmassist.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest 
{

	@NotNull(message ="Name cannot be null")
	@NotBlank(message ="Name cannot be blank")
	@Pattern(regexp ="^[A-Za-z0-9'\\-\\s]{3,50}$",message = "Invalid name")
	private String name;

	@NotNull(message = "gstNo cannot be null")
	@NotBlank(message = "gstNo cannot be blank")
	@Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[A-Z0-9]{3}$",
	message = "Invalid GST number")
	private String gstNo;

	@NotNull(message = "licenseNo cannot be null")
	@NotBlank(message = "licenseNo cannot be blank")
	@Pattern(regexp = "^[A-Z0-9]{10,15}$",
	message = "Invalid Licence number")
	private String licenceNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}



}
