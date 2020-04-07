package com.tweb.salas.subirFicheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/documentos")
public class FileUploadController {
	
	@Autowired
	private StorageService storageService;

	/*
	 * @Autowired public FileUploadController(StorageService storageService) {
	 * this.storageService = storageService; }
	 */

	@RequestMapping("/subirArchivo/{id}")
	public String listUploadedFiles(@PathVariable("id") Integer id, Model model) throws IOException {
		// Agregamos el id del evento para tratarlo y crear los directorios
		model.addAttribute("id", id);
		
		// Ruta y nombre de las carpetas a crear para cada evento
		storageService.setLocation("src/main/webapp/documentos/archivosSubidos/evento" + id);		
		storageService.init();
		
		// Agregamos los ficheros que existen dentro de la carpeta del evento
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
				"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));
		
		// Retorno a agregar más ficheros dentro de la carpeta del evento
		return "../loadArchivo";
	}

	@RequestMapping("/archivosSubidos/eventos/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable("filename") String filename) {

		Resource file = storageService.loadAsResource(filename);
		
		System.out.println("File getFileName: " + file.getFilename());
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/guardarArchivo")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"El archivo ha sido cargado..." + file.getOriginalFilename() + "!");

		return "redirect:/salas";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}