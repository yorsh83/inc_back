package com.att.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.att.model.Reporte;

public interface IReporteDAO extends JpaRepository<Reporte, Integer> {

	@Query(value = "SELECT COUNT(*) FROM inc_pos_upload", nativeQuery = true)
	Integer contadorTotalIncidentes();
	
	@Query(value = "SELECT COUNT(USUARIO) FROM inc_pos_upload", nativeQuery = true)
	Integer contadorTotalIncidentesTomados();

	@Query(value = "SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 1", nativeQuery = true)
	Integer contadorAnalisis();

	@Query(value = "SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 2", nativeQuery = true)
	Integer contadorConstruccion();

	@Query(value = "SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 3", nativeQuery = true)
	Integer contadorPruebas();

	@Query(value = "SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 4", nativeQuery = true)
	Integer contadorLiberacion();
	
	@Query(value = "SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 5", nativeQuery = true)
	Integer contadorRetro();

}
