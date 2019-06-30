package com.org.infy.binary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.infy.binary.entity.Phrase;

public interface PhraseRepository extends JpaRepository<Phrase, Integer>{

	public List<Phrase> findByDocumentId(String documentId);
}
