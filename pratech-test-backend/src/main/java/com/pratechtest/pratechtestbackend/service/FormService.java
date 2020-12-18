package com.pratechtest.pratechtestbackend.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratechtest.pratechtestbackend.dto.response.FormDTOResponse;
import com.pratechtest.pratechtestbackend.entity.Form;
import com.pratechtest.pratechtestbackend.entity.Question;
import com.pratechtest.pratechtestbackend.irepository.IFormRepository;
import com.pratechtest.pratechtestbackend.iservice.IFormService;
import com.pratechtest.pratechtestbackend.response.FinalResponse;


@Service
public class FormService implements IFormService{
	
	@Autowired private IFormRepository formRepository;
	@Autowired private FinalResponse finalResponse;
	private HttpHeaders httpHeaders = new HttpHeaders();

	@Override
	public ResponseEntity<String> getAll() {
		List<Form> formsFound = formRepository.findAll();
		List<FormDTOResponse> formsDTOList = new ArrayList<FormDTOResponse>();
		FormDTOResponse formDTO;
		for(Form formFound : formsFound) {
			formDTO = new FormDTOResponse(formFound.getId(),formFound.getFormName(), formFound.getQuestions());
			formsDTOList.add(formDTO);
		}
		return finalResponse.getResponse(formsDTOList, httpHeaders, HttpStatus.OK).toResponseEntity();
	}

}
