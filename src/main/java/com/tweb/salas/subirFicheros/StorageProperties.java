package com.tweb.salas.subirFicheros;

import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
	
	/**
	 * Folder location for storing files
	 */
	private String location = "src/main/webapp/documentos/archivosSubidos";
	private Path rootLocation;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}	

	public Path getRootLocation() {
		return rootLocation;
	}

	public void setRootLocation(Path rootLocation) {
		this.rootLocation = rootLocation;
	}

	@Override
	public String toString() {
		return "StorageProperties [location=" + location + ", rootLocation=" + rootLocation + "]";
	}
}
