package com.att.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.att.model.Archivo;
import com.att.service.IArchivoService;

@RestController
@RequestMapping("/archivos")
public class ArchivoApi {

	private static final Logger log = LoggerFactory.getLogger(ArchivoApi.class);

	@Autowired
	private IArchivoService service;

	@GetMapping
	public ResponseEntity<List<Archivo>> listarTodo() {
		return new ResponseEntity<List<Archivo>>(service.listarTodo(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Archivo> listarPorId(@PathVariable("id") String id) {
		return new ResponseEntity<Archivo>(service.archivoPorId(id), HttpStatus.OK);
	}

	/*
	 * @GetMapping(value = "/reporte", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<Reporte>> listarReporte() { List<Reporte> reporte
	 * = new ArrayList<>(); reporte = service.listarGrafica(); return new
	 * ResponseEntity<List<Reporte>>(reporte, HttpStatus.OK); }
	 */

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Archivo>> listarPageable(Pageable pageable) {
		Page<Archivo> archivos;
		archivos = service.listarPageable(pageable);
		return new ResponseEntity<Page<Archivo>>(archivos, HttpStatus.OK);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> actualizarKanban(@RequestBody Archivo ar) {
		Archivo archivo = new Archivo();
		archivo = service.modificar(ar);
		return new ResponseEntity<Object>(archivo, HttpStatus.OK);
	}

	@PostMapping(value = "/guardarArchivo", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Boolean> guardarArchivo(@RequestParam("file") MultipartFile file)
			throws IOException, ParseException {
		List<String> lstStatus = new ArrayList<>();
		lstStatus.add("Asignado");
		lstStatus.add("En curso");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		boolean rpta = false;
		String selectedFile = file.getOriginalFilename();
		// File f = new File("C://test//Incidentes pospago.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C://test//" + selectedFile));
		// XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(f));
		XSSFSheet sheet = wb.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		for (int i = 4; i <= rows; ++i) {
			XSSFRow row = sheet.getRow(i);

			XSSFCell idIncident = row.getCell(0);
			// si ya existe no lo inserta
			String a = service.validarIncidentes(idIncident.getStringCellValue());
			if (a == null || !idIncident.getStringCellValue().equals(a)) {
				XSSFCell srid = row.getCell(1);
				XSSFCell name = row.getCell(2);
				XSSFCell detailDescription = row.getCell(3);
				XSSFCell status = row.getCell(4);
				for (String st : lstStatus) {
					if (status.getStringCellValue().equalsIgnoreCase(st)) {
						log.info("valor status " + status);
						XSSFCell priority = row.getCell(5);
						XSSFCell assignedGroup = row.getCell(6);
						XSSFCell assignee = row.getCell(7);
						XSSFCell slmStatus = row.getCell(8);
						XSSFCell submitDate = row.getCell(9);
						XSSFCell lastModifiedDate = row.getCell(10);
						XSSFCell lastResolvedDate = row.getCell(11);

						// cuando el campo fecha resuelto viene en blanco//
						if (lastResolvedDate.toString().isEmpty()) {
							LocalDate dateEmpty = LocalDate.of(1990, Month.JANUARY, 01);
							lastResolvedDate.setCellValue(dateEmpty);
						}
						// cuando el campo fecha resuelto viene en blanco//

						Archivo ar = new Archivo();
						ar.setIdIncident(idIncident.getStringCellValue());
						ar.setSrid(srid.getStringCellValue());
						ar.setName(name.getStringCellValue());
						ar.setDetailDescription(detailDescription.getStringCellValue());
						ar.setStatus(status.getStringCellValue());
						ar.setPriority(priority.getStringCellValue());
						ar.setAssignedGroup(assignedGroup.getStringCellValue());
						ar.setAssignee(assignee.getStringCellValue());
						ar.setSlmStatus(slmStatus.getStringCellValue());
						String submitDateF = format.format(submitDate.getDateCellValue());
						ar.setSubmitDate(submitDateF);
						String lastModifiedDateF = format.format(lastModifiedDate.getDateCellValue());
						ar.setLastModifiedDate(lastModifiedDateF);
						String lastResolvedDateF = format.format(lastResolvedDate.getDateCellValue());
						ar.setLastResolvedDate(lastResolvedDateF);

						rpta = service.guardar(ar);
					} else {
						log.info("EL INCIDETE ESTA CERRADO O CANCELADO");
					}
				}
			} else {
				log.info("YA EXISTE EL INCIDENTE");
			}

			// si ya existe no lo inserta
		}
		return new ResponseEntity<Boolean>(rpta, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Archivo archivo = service.listarId(id);
		service.eliminar(archivo.getId());
	}

}
