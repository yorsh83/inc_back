package com.att.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.model.Archivo;
import com.att.model.Kanban;
import com.att.service.IArchivoService;
import com.att.service.IKanbanService;

@RestController
@RequestMapping("/kanbans")
public class KanbanApi {

	private static final Logger log = LoggerFactory.getLogger(KanbanApi.class);

	@Autowired
	private IKanbanService service;

	@Autowired
	private IArchivoService servArchivo;

	@GetMapping(value = "/analisis")
	public ResponseEntity<List<Kanban>> lstAnalisis() {
		return new ResponseEntity<List<Kanban>>(service.lstAnalisis(), HttpStatus.OK);
	}

	@GetMapping(value = "/construccion")
	public ResponseEntity<List<Kanban>> lstConstruccion() {
		return new ResponseEntity<List<Kanban>>(service.lstConstruccion(), HttpStatus.OK);
	}

	@GetMapping(value = "/pruebas")
	public ResponseEntity<List<Kanban>> lstPruebas() {
		return new ResponseEntity<List<Kanban>>(service.lstPruebas(), HttpStatus.OK);
	}

	@GetMapping(value = "/liberacion")
	public ResponseEntity<List<Kanban>> lstLiberacion() {
		return new ResponseEntity<List<Kanban>>(service.lstLiberacion(), HttpStatus.OK);
	}

	@GetMapping(value = "/retrospectiva")
	public ResponseEntity<List<Kanban>> lstRetrospectiva() {
		return new ResponseEntity<List<Kanban>>(service.lstRetrospectiva(), HttpStatus.OK);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrar(@RequestBody Kanban kan) {
		Kanban kanban = new Kanban();
		kan.setStatusKanban("1");
		kanban = service.agregar(kan);
		return new ResponseEntity<Object>(kanban, HttpStatus.OK);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> actualizarTexto(@RequestBody Kanban kan) {
		Kanban kanban = new Kanban();
		kanban = service.modificar(kan);
		return new ResponseEntity<Object>(kanban, HttpStatus.OK);
	}

	@PutMapping(value = "/flujo", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> actualizarFlujo(@RequestBody Kanban kan) {
		log.info("entra");
		Kanban kanban = new Kanban();
		kanban = service.modificar(kan);
		return new ResponseEntity<Object>(kanban, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Kanban kanban = service.listarId(id);
		log.info("k: " + kanban.getId() + " - " + kanban.getIdIncident() + " - " + kanban.getIdArchivo());
		Archivo archivo = servArchivo.listarId(kanban.getIdArchivo());
		log.info("a " + archivo.getId() + " - " + archivo.getIdIncident());
		service.eliminar(kanban.getId());
		servArchivo.eliminar(archivo.getId());
	}

}
