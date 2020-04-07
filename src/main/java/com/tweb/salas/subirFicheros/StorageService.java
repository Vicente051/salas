package com.tweb.salas.subirFicheros;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	void store(MultipartFile file);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();
	
	String getLocation();
	
	void setLocation(String location);
	
	
	public StorageProperties getProperties();
	
	public void setProperties(StorageProperties properties);
	
	

}
