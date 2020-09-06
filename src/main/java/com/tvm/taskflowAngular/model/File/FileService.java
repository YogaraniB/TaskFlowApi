package com.tvm.taskflowAngular.model.File;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	@Autowired
	FileRepository fileRepository;

	public void save(FileModel filemode) {
		// TODO Auto-generated method stub
		fileRepository.save(filemode);
		
	}
	public Optional<FileModel> getFile(Long fileId) {
        return fileRepository.findById(fileId);
                
    }
	
}
