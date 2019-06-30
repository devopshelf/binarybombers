package com.org.infy.binary.request.model;

import java.util.List;

public class PhraseModel {
	private String documentId;
	private String documentName;
	private List<PhraseInfo> phraseInfo = null;

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public List<PhraseInfo> getPhraseInfo() {
		return this.phraseInfo;
	}

	public void setPhraseInfo(List<PhraseInfo> phraseInfo) {
		this.phraseInfo = phraseInfo;
	}

}