package com.att.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.dao.IKanbanDAO;
import com.att.model.Kanban;
import com.att.service.IKanbanService;

@Service
public class KanbanServiceImpl implements IKanbanService {

	@Autowired
	private IKanbanDAO dao;

	@Override
	public Kanban modificar(Kanban t) {
		return dao.save(t);
	}

	@Override
	public Kanban agregar(Kanban t) {
		return dao.save(t);
	}

	@Override
	public List<Kanban> lstAnalisis() {
		return dao.lstAnalisis();
	}

	@Override
	public List<Kanban> lstConstruccion() {
		return dao.lstConstruccion();
	}

	@Override
	public List<Kanban> lstPruebas() {
		return dao.lstPruebas();
	}

	@Override
	public List<Kanban> lstLiberacion() {
		return dao.lstLiberacion();
	}

	@Override
	public List<Kanban> lstRetrospectiva() {
		return dao.lstRetrospectiva();
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Kanban listarId(int id) {
		Kanban k = dao.getOne(id);
		return k;
	}

	@Override
	public List<Kanban> listarTodo() {
		return null;
	}

}
