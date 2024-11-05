package com.example.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.entity.Patient;
import com.example.pharmassist.requestdtos.PatientRequest;
import com.example.pharmassist.responsedtos.PatientResponse;

@Component
public class PatientMapper 
{
	public Patient mapToPatient(PatientRequest patientRequest,Patient patient)
	{
		patient.setName(patientRequest.getName());
		patient.setPhoneNumber(patientRequest.getPhoneNumber());
		patient.setEmail(patientRequest.getEmail());
		patient.setGender(patientRequest.getGender());
		patient.setDateOfBirth(patientRequest.getDateOfBirth());

		return patient;
	}

	public PatientResponse mapToPatientResponse(Patient patient)
	{
		PatientResponse patientResponse=new PatientResponse();
		patientResponse.setPatientId(patient.getPatientId());
		patientResponse.setName(patient.getName());
		patientResponse.setPhoneNumber(patient.getPhoneNumber());
		patientResponse.setEmail(patient.getEmail());
		patientResponse.setGender(patient.getGender());
		patientResponse.setDateOfBirth(patient.getDateOfBirth());

		return patientResponse;
	}
}
