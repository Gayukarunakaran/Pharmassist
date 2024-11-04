package com.example.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.requestdtos.PharmacyRequest;
import com.example.pharmassist.responsedtos.PharmacyResponse;

@Component
public class PharmacyMapper 
{
	public Pharmacy mapToPharmacy(PharmacyRequest pharmacyRequest,Pharmacy pharmacy)
	{
		pharmacy.setName(pharmacyRequest.getName());
		pharmacy.setGstNo(pharmacyRequest.getGstNo());
		pharmacy.setLicenceNo(pharmacyRequest.getLicenceNo());

		return pharmacy;
	}

	public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy)
	{
		PharmacyResponse pharmacyResponse=new PharmacyResponse();
		pharmacyResponse.setPharmacyId(pharmacy.getPharmacyId());
		pharmacyResponse.setName(pharmacy.getName());
		pharmacyResponse.setGstNo(pharmacy.getGstNo());
		pharmacyResponse.setLicenceNo(pharmacy.getLicenceNo());

		return pharmacyResponse;
	}

}

