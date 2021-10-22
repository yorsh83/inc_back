package com.att.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.service.IReporteService;

@RestController
@RequestMapping("/reportes")
public class ReporteApi {

	//private static final Logger log = LoggerFactory.getLogger(ReporteApi.class);

	@Autowired
	private IReporteService service;

	@GetMapping(value = "/total")
	public ResponseEntity<Integer> contadorTotal() {
		return new ResponseEntity<Integer>(service.contadorTotalIncidentes(), HttpStatus.OK);
	}

	@GetMapping(value = "/tomados")
	public ResponseEntity<Integer> contadorTomados() {
		return new ResponseEntity<Integer>(service.contadorTotalIncidentesTomados(), HttpStatus.OK);
	}

	@GetMapping(value = "/analisis")
	public ResponseEntity<Integer> contadorAnalisis() {
		return new ResponseEntity<Integer>(service.contadorAnalisis(), HttpStatus.OK);
	}

	@GetMapping(value = "/construccion")
	public ResponseEntity<Integer> contadorConstruccion() {
		return new ResponseEntity<Integer>(service.contadorConstruccion(), HttpStatus.OK);
	}

	@GetMapping(value = "/pruebas")
	public ResponseEntity<Integer> contadorPruebas() {
		return new ResponseEntity<Integer>(service.contadorPruebas(), HttpStatus.OK);
	}

	@GetMapping(value = "/liberacion")
	public ResponseEntity<Integer> contadorLiberacion() {
		return new ResponseEntity<Integer>(service.contadorLiberacion(), HttpStatus.OK);
	}

	@GetMapping(value = "/retro")
	public ResponseEntity<Integer> contadorRetro() {
		return new ResponseEntity<Integer>(service.contadorRetro(), HttpStatus.OK);
	}

	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

}
