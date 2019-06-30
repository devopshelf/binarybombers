package com.org.infy.binary.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import com.org.infy.binary.model.DocumentList;
import com.org.infy.binary.request.model.PhraseModel;;

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

	public List<DocumentList> findDocumentList() {
		List<DocumentList> list = ListDocumentHelper.displayDirectoryContents(new File("D:/eclipse workspace/infy-binary/files"));
		return list;
	}
	public List<DocumentList> updatePhrases(PhraseModel phm) {
		bbDao.updateDataset(phm);
		return null;
	}

}