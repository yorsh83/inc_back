package com.att.service;

import java.util.List;

import com.att.model.Kanban;

public interface IKanbanService extends ICRUD<Kanban> {

	List<Kanban> lstAnalisis();

	List<Kanban> lstConstruccion();

	List<Kanban> lstPruebas();

	List<Kanban> lstLiberacion();

	List<Kanban> lstRetrospectiva();

}
