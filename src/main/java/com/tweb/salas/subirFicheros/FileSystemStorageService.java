package com.tweb.salas.subirFicheros;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

	@Autowired
	public StorageProperties properties;
	
	private Path rootLocation;	
	
	  @Autowired
	  public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation()); }
	 
	
	
	@Override
	public void store(MultipartFile file) {
		
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new StorageException("Error al almacenar un archivo vacío " + filename);
				
				
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new StorageException(
						"\n" + 
						"No se puede almacenar el archivo con la ruta relativa fuera del directorio actual "
								+ filename);
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(filename),
					StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file " + filename, e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new StorageException("Error al leer los archivos almacenados", e);
		}

	}

	@Override
	public Path load(String filename) {
		return this.rootLocation.resolve(filename);
	}

	@Override
	public StorageProperties getProperties() {
		return properties;
	}

	@Override
	public void setProperties(StorageProperties properties) {
		this.properties = properties;
	}

	public Path getRootLocation() {
		return rootLocation;
	}

	public void setRootLocation(Path rootLocation) {
		this.rootLocation = rootLocation;
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException(
						"No se puede leer el archivo: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("No se puede leer el archivo: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {
		try {
			
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new StorageException("El almacenamiento no se pudo inicializar.", e);
		}
	}

	@Override
	public String toString() {
		return rootLocation.toString();
	}
	
	@Override
	public void setLocation(String location) {
		
		properties.setLocation(location);
		this.rootLocation = Paths.get(properties.getLocation());		
	}

	@Override
	public String getLocation() {
		// TODO Apéndice de método generado automáticamente
		return properties.getLocation();
	}
	
	
}
