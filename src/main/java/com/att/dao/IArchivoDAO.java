package com.att.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.att.model.Archivo;

public interface IArchivoDAO extends JpaRepository<Archivo, Integer> {

	@Query(value = "select * from inc_pos_reporte", nativeQuery = true)
	List<Object[]> listarGrafica();

	@Query(value = "select id_incident from inc_pos_upload where id_incident = :incident", nativeQuery = true)
	String validarIncidentes(String incident);

	@Query(value = "select id_incident from inc_pos_upload where usuario LIKE '%'", nativeQuery = true)
	List<String> incObtendio();

	@Query(value = "SELECT * FROM INC_POS_UPLOAD ipu WHERE ID_INCIDENT = :idIncidente", nativeQuery = true)
	Archivo archivoPorId(String idIncidente);

}
