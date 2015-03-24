package com.mgo.project.service;

import java.io.File;

import org.springframework.stereotype.Service;
@Service
public class FileListServiceImpl implements FileListService{

	@Override
	public File[] getFileList(String dirName) {
			if(new File(dirName).exists());
				File directory = new File(dirName);
				File[] files = directory.listFiles();
				return files;
		}
	}
	

