package com.example.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;

@Component
public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setAdminEmail(adminRequest.getEmail());
		admin.setAdminPhoneNumber(adminRequest.getPhoneNumber());
		admin.setAdminPassword(adminRequest.getPassword());
		
		return admin;
	}
	
	public AdminResponse mapToAdminResponse(Admin admin) {
		
		AdminResponse adminResponse=new AdminResponse();
		adminResponse.setAdminId(admin.getAdminId());
		adminResponse.setEmail(admin.getAdminEmail());
		adminResponse.setPhoneNumber(admin.getAdminPhoneNumber());
		
		return adminResponse;
	}

}
