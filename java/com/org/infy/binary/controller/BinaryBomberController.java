package com.org.infy.binary.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.infy.binary.entity.Phrase;
import com.org.infy.binary.exception.PaginationErrorResponse;
import com.org.infy.binary.exception.PaginationException;
import com.org.infy.binary.model.DocumentList;
import com.org.infy.binary.request.model.PhraseModel;
import com.org.infy.binary.service.BinaryBomberService;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      Contributors: Samrat Basu. June 14, 2019
 * @param <T>
 ******************************************************************************/

@RestController
@RequestMapping(value = "/bb")
public class BinaryBomberController<T> {
	private final static Logger log = Logger.getLogger(BinaryBomberController.class);

	@Autowired
	private BinaryBomberService<T> bbService;

	
	@RequestMapping(value = "/rest/getDocumentList",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DocumentList> getDocumentList() {
		log.debug("Inside get document Controller");		
		long starttime = System.currentTimeMillis();
		List<DocumentList> docList = bbService.findDocumentList();	
		
		long endtime = System.currentTimeMillis();
		log.debug("Total processing time "+ (endtime -starttime)+ " ms.");
		
		return docList;
	}
	
	@RequestMapping(value = "/rest/updatePhrases",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DocumentList> updatePhrases(@RequestBody final PhraseModel phm) {
		log.debug("Inside Update Phrases Controller");		
		long starttime = System.currentTimeMillis();
		List<DocumentList> docList = bbService.updatePhrases(phm);	
		long endtime = System.currentTimeMillis();
		log.debug("Total processing time "+ (endtime -starttime)+ " ms.");
		
		return docList;
	}
	
}