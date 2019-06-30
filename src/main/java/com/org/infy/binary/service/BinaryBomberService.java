package com.org.infy.binary.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.infy.binary.dao.BinaryBomberDAO;
import com.org.infy.binary.entity.Phrase;
import com.org.infy.binary.entity.PhraseInfoEntity;
import com.org.infy.binary.model.DocContent;
import com.org.infy.binary.model.DocumentList;
import com.org.infy.binary.repository.PhraseInfoRepository;
import com.org.infy.binary.request.model.PhraseInfo;
import com.org.infy.binary.request.model.PhraseModel;
import com.org.infy.binary.response.model.ResponseStatus;;

/*******************************************************************************
 * Copyright (c) 2019 Infosys Ltd. All rights reserved.
 * 
 * Contributors: Samrat Basu. June 14, 2019
 * 
 * @param <T>
 ******************************************************************************/
@Service
public class BinaryBomberService<T> {
	private final static Logger log = Logger.getLogger(BinaryBomberService.class);
	@Autowired
	private BinaryBomberDAO bbDao;
	
	@Autowired
	private PhraseInfoRepository phraseInfoRepository;
	
	@Autowired
	private DocReader docReader;

	public List<DocumentList> findDocumentList() {
		String path = System.getProperty("user.dir")+"/files";
		log.debug("Directory :"+path);
		List<DocumentList> list = ListDocumentHelper.displayDirectoryContents(new File(path));
		return list;
	}
	
	public ResponseStatus updatePhrases(PhraseModel phm) {
		ResponseStatus resStat= bbDao.updateDataset(phm);
		return resStat;
	}
	
	
	 public DocContent getDocsContent(String fileName) {
		 DocContent docContent = new DocContent();
		 String path = System.getProperty("user.dir")+"/files";
		 docContent.setFileName(path+"/"+fileName);
		 docContent.setDocContent(docReader.readDoc(docContent.getFileName()));
		 return docContent;
	} 
	 
	 public Object getPhrases(String documentID) {
			Object resStat= bbDao.findRecordSet(documentID);
			return resStat;
	}

	public Object getAllPhrases() {
		Collection<PhraseInfo> phrases = new ArrayList<PhraseInfo>(); 
		Iterable<PhraseInfoEntity> phrasesInfo = phraseInfoRepository.findAll();
		
		for(PhraseInfoEntity phraseInfoEntity : phrasesInfo) {
			PhraseInfo phraseInfo = new PhraseInfo();
			phraseInfo.setLength(phraseInfoEntity.getLength());
			phraseInfo.setTime(phraseInfoEntity.getTime());
			phraseInfo.setPhrase(phraseInfoEntity.getPhrase());
			phrases.add(phraseInfo);
		}
		return phrases;
	}

}