package com.mgo.project.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgo.project.service.FileListService;

@RestController
@RequestMapping("/files")
public class FileController {
	
	private FileListService fileListService;
	@Autowired
	FileController(FileListService fileListService) {
        this.fileListService = fileListService;
    }

	@RequestMapping(value="/path",method = RequestMethod.GET)
	File[] getFileList(@RequestParam (value="dirPath", required = true)String dirPath){
	   File[] files = fileListService.getFileList(dirPath);
	   return files;
	}
}
