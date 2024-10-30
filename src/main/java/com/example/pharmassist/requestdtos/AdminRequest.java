package com.example.pharmassist.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {

	@NotNull(message="Email is not to be null")
	@NotBlank(message="Email is not to be blank")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
	message="Inavlid Email ID")
	private String email;

	@NotNull(message="Phone Number is not to be null")
	@NotBlank(message="Phone Number is not to be blank")
	@Pattern(regexp = "^[6-9]\\d{9}$",
	message="Inavlid Phone Number")	
	private String phoneNumber;


	@NotNull(message="Password is not to be null")
	@NotBlank(message="Password is not to be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,18}$"
	,message="Password must be 8-18 characters long, containing at least one uppercase letter, one lowercase letter, one number, and one special character (@, $, !, %, *, ?, &).")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
