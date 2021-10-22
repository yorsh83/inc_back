package com.att.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.att.dao.IArchivoDAO;
import com.att.model.Archivo;
import com.att.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoDAO dao;

	@Override
	public Archivo cargarArchivo(Archivo t) {
		return dao.save(t);
	}

	@Override
	public Archivo modificar(Archivo t) {
		return dao.save(t);
	}

	@Override
	public List<Archivo> listarTodo() {
		return dao.findAll();
	}

	@Override
	public boolean guardar(Archivo archivo) {
		dao.save(archivo);
		return true;
	}

	@Override
	public Page<Archivo> listarPageable(Pageable pageable) {
		return dao.findAll(pageable);
	}

	/*
	 * @Override public List<Reporte> listarGrafica() { List<Reporte> listadoReporte
	 * = new ArrayList<>();
	 * 
	 * dao.listarGrafica().forEach(x -> { Reporte r = new Reporte();
	 * r.setResueltos(Integer.parseInt(String.valueOf(x[0])));
	 * r.setPedientes(Integer.parseInt(String.valueOf(x[1])));
	 * r.setProcesos(Integer.parseInt(String.valueOf(x[2]))); listadoReporte.add(r);
	 * }); return listadoReporte; }
	 */

	@Override
	public String validarIncidentes(String incident) {
		String validar = dao.validarIncidentes(incident);
		return validar;
	}

	@Override
	public Archivo archivoPorId(String idIncidente) {
		Archivo valor = dao.archivoPorId(idIncidente);
		return valor;
	}

	@Override
	public List<String> incObtendio() {
		List<String> listado = dao.incObtendio();
		return listado;
	}

	@Override
	public Archivo listarId(int id) {
		return dao.getOne(id);
	}

	@Override
	public Archivo agregar(Archivo t) {
		return null;
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

}
