package com.org.infy.binary.dao;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.infy.binary.entity.Phrase;
import com.org.infy.binary.entity.PhraseInfoEntity;
import com.org.infy.binary.repository.BinaryBomberRepository;
import com.org.infy.binary.request.model.PhraseInfo;
import com.org.infy.binary.request.model.PhraseModel;

@Repository
public class BinaryBomberDAO {
	private final static Logger log = Logger.getLogger(BinaryBomberDAO.class);
@Autowired 
private BinaryBomberRepository bbRepository;


	public void updateDataset(PhraseModel phm){	
		Phrase phraseEntity = new Phrase();
		PhraseInfoEntity phEntity = new PhraseInfoEntity();
		List<PhraseInfoEntity> phEntityList = new ArrayList<PhraseInfoEntity>();
		phraseEntity.setDocumentId(phm.getDocumentId());
		phraseEntity.setFileName(phm.getDocumentName());
		
		for (PhraseInfo ph : phm.getPhraseInfo()) {
			phEntity.setPhrase(ph.getPhrase());
			phEntity.setLength(ph.getLength());
			phEntity.setTime(ph.getTime());
			phEntityList.add(phEntity);
		}
		phraseEntity.setPhraseInfo(phEntityList);
		bbRepository.save(phraseEntity);
	}
}
