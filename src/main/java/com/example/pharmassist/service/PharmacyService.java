package com.example.pharmassist.service;

import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.exception.PharmacyNotFoundException;
import com.example.pharmassist.mapper.PharmacyMapper;
import com.example.pharmassist.repository.AdminRepository;
import com.example.pharmassist.repository.PharmacyRepository;
import com.example.pharmassist.requestdtos.PharmacyRequest;
import com.example.pharmassist.responsedtos.PharmacyResponse;
import com.example.pharmassist.util.AppResponseBuilder;


@Service
public class PharmacyService 
{
	private final PharmacyRepository pharmacyRepository;
	private final AdminRepository adminRepository;
	private final PharmacyMapper pharmacyMapper;

	public PharmacyService(PharmacyRepository pharmacyRepository,AdminRepository adminRepository,AppResponseBuilder appResponseBuilder,PharmacyMapper pharmacyMapper)
	{
		this.pharmacyRepository=pharmacyRepository;
		this.pharmacyMapper=pharmacyMapper;
		this.adminRepository=adminRepository;
	}

	public PharmacyResponse addPharmacy(PharmacyRequest pharmacyRequest,String adminId)
	{
		return adminRepository.findById(adminId)
				.map( admin ->{
					Pharmacy pharmacy=pharmacyMapper.mapToPharmacy(pharmacyRequest, new Pharmacy());
					pharmacy=pharmacyRepository.save(pharmacy);
					admin.setPharmacy(pharmacy);
					adminRepository.save(admin);
					return pharmacyMapper.mapToPharmacyResponse(pharmacy);				
				})
				.orElseThrow(() ->new AdminNotFoundByIdException("Failed to find Admin"));
	}

	public PharmacyResponse findPharmacyByAdminId(String adminId)
	{
		Admin admin=adminRepository.findById(adminId)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to Find Admin"));

		Pharmacy pharmacy=adminRepository.findPharmacyByAdminId(adminId);
		if(pharmacy==null)
		{
			throw new PharmacyNotFoundException("No Pharmacy associated with admin ID:"+adminId);
		}
		return pharmacyMapper.mapToPharmacyResponse(pharmacy);

		//		return adminRepository.findById(adminId)
		//				.map(Admin::getPharmacy)  // Extract the pharmacy from the admin
		//				.map(pharmacyMapper::mapToPharmacyResponse)  // Map Pharmacy to PharmacyResponse
		//				.orElseThrow(() -> new PharmacyNotFoundException("No Pharmacy associated with admin ID:"+adminId));

	}

}
