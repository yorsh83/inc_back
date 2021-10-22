package com.att.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.att.model.Archivo;

public interface IArchivoService extends ICRUD<Archivo> {

	Archivo cargarArchivo(Archivo archivo);

	boolean guardar(Archivo archivo);

	Page<Archivo> listarPageable(Pageable pageable);

	//List<Reporte> listarGrafica();

	String validarIncidentes(String incident);

	List<String> incObtendio();

	Archivo archivoPorId(String idIncidente);

}
