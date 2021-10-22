package com.att.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.att.model.Kanban;

public interface IKanbanDAO extends JpaRepository<Kanban, Integer> {

	@Query(value = "select * from inc_pos_kanban where status_kanban = 1", nativeQuery = true)
	List<Kanban> lstAnalisis();

	@Query(value = "select * from inc_pos_kanban where status_kanban = 2", nativeQuery = true)
	List<Kanban> lstConstruccion();

	@Query(value = "select * from inc_pos_kanban where status_kanban = 3", nativeQuery = true)
	List<Kanban> lstPruebas();

	@Query(value = "select * from inc_pos_kanban where status_kanban = 4", nativeQuery = true)
	List<Kanban> lstLiberacion();

	@Query(value = "select * from inc_pos_kanban where status_kanban = 5", nativeQuery = true)
	List<Kanban> lstRetrospectiva();

}
