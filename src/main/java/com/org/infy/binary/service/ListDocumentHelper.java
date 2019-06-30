package com.org.infy.binary.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.org.infy.binary.model.DocumentList;

public class ListDocumentHelper {
	private final static Logger log = Logger.getLogger(ListDocumentHelper.class);
	
	
	public static List<DocumentList> displayDirectoryContents(File fileDir) {
	 List<DocumentList> dlList = new ArrayList<DocumentList>();
		DocumentList dl = new DocumentList();
		
		try {
			File[] files = fileDir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					log.debug("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					log.debug("Absolute Path:" + file.getCanonicalPath() + " Size:"+file.length()+" file Path"+file.getPath());
					dl.setFileName(file.getName());
					dl.setUrl(file.getCanonicalPath());
					dl.setSize(file.length());
					dl.setId(file.getParent()+"_"+file.getName());
					dlList.add(dl);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dlList;
		
	}
}
