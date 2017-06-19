package com.example.controller.service;

import java.net.URL;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.example.vo.Patient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@Component
public class PatientService {
	
public Patient getPatient(String id) {
		
		Patient patientDetails=null;
		System.out.println("Entered service getPatientDetails with id : " + id);
		
		try
		{
			URL resource = Resources.getResource("patients.json");
			String json = Resources.toString(resource, Charsets.UTF_8);

	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        Patient[] patientList = objectMapper.readValue(json, Patient[].class);
	        
	      
	        patientDetails=Arrays.stream(patientList).filter(patient -> patient.getPatientId().equalsIgnoreCase(id)).findFirst().orElse(null);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return patientDetails;
		
		
    }

}
