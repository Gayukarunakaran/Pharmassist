package com.example.pharmassist.requestdtos;

import java.time.LocalDate;

import com.example.pharmassist.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientRequest 
{
	@NotNull(message ="Name cannot be null")
	@NotBlank(message ="Name cannot be blank")
	@Pattern(regexp ="^[A-Za-z]+$",message = "Invalid name")
	private String name;

	@NotNull(message="Phone Number is not to be null")
	@NotBlank(message="Phone Number is not to be blank")
	@Pattern(regexp = "^[6-9]\\d{9}$",
	message="Inavlid Phone Number")
	private String phoneNumber;

	@NotNull(message="Email is not to be null")
	@NotBlank(message="Email is not to be blank")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
	message="Inavlid Email ID")
	private String email;

	@NotNull(message="Gender cannot be null")
	private Gender gender;

	@NotNull(message="DOB cannot be null")
	private LocalDate dateOfBirth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
