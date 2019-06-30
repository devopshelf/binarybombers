package com.org.infy.binary.dao;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.infy.binary.entity.Phrase;
import com.org.infy.binary.entity.PhraseInfoEntity;
import com.org.infy.binary.repository.PhraseRepository;
import com.org.infy.binary.request.model.PhraseInfo;
import com.org.infy.binary.request.model.PhraseModel;
import com.org.infy.binary.response.model.ResponseStatus;

@Repository
public class BinaryBomberDAO {
	private final static Logger log = Logger.getLogger(BinaryBomberDAO.class);
	@Autowired 
	private PhraseRepository bbRepository;


	public ResponseStatus updateDataset(PhraseModel phm) {
		Phrase phraseEntity = new Phrase();
		ResponseStatus resStatus = new ResponseStatus();
		try {
			phraseEntity.setDocumentId(phm.getDocumentId());
			phraseEntity.setFileName(phm.getDocumentName());
			for (PhraseInfo ph : phm.getPhraseInfo()) {
				PhraseInfoEntity phEntity = new PhraseInfoEntity();
				phEntity.setPhrase(ph.getPhrase());
				phEntity.setLength(ph.getLength());
				phEntity.setTime(ph.getTime());
				phraseEntity.getPhraseInfo().add(phEntity);
			}
			bbRepository.saveAndFlush(phraseEntity);
			resStatus.setStatCode(200);
			resStatus.setStatus("success");
			resStatus.setMessage("Data successfully saved");
			
		} catch (Exception ex) {
			resStatus.setStatCode(401);
			resStatus.setStatus("failure");
			resStatus.setMessage(ex.getCause().toString());
			ex.printStackTrace();
		}
		return resStatus;
}
	
	public Object findRecordSet(String documentID) {
		Object obj=null;
		obj=bbRepository.findByDocumentId(documentID);
		return obj;
	}
}
