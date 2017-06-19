package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.service.PatientService;
import com.example.vo.Patient;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatientDetails(@PathVariable("id") String id) {
		
		 return this.patientService.getPatient(id);
    }

}
