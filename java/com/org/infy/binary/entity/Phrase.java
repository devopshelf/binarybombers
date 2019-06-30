package com.org.infy.binary.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
@Entity
@Table(name = "Phrase")
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name="HiveTable.findQuote",
 * query="SELECT h FROM HiveTable h WHERE h.quote =:quote"),
 * 
 * @NamedQuery(name="HiveTable.findAll", query="SELECT h FROM HiveTable h") })
 */
public class Phrase {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO) 
	
	  @Column(name = "id") private Integer id;
	 
	@Column(name = "document_id")
	private String documentId;
	@Column(name = "file_Name")
	private String fileName;
	@Column(name = "phrase")
	@OneToMany(cascade=CascadeType.ALL)
    private List<PhraseInfoEntity> phraseInfo;

	/*
	 * public Integer getId() { return id; } public void setId(Integer id) { this.id
	 * = id; }
	 */
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<PhraseInfoEntity> getPhraseInfo() {
		return phraseInfo;
	}
	public void setPhraseInfo(List<PhraseInfoEntity> phraseInfo) {
		this.phraseInfo = phraseInfo;
	}
	
	
	
	
}