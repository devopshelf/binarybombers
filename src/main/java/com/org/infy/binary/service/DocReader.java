package com.org.infy.binary.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DocReader {
	public String readDoc(String fileName) {
		String content = "";
		WordExtractor extractor = null;
		try {
         FileInputStream fis = new FileInputStream(new File(fileName));
         HWPFDocument doc = new HWPFDocument(fis);
         extractor = new WordExtractor(doc);
         content = extractor.getText();
		 extractor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return content;
	}	
	
	
}
