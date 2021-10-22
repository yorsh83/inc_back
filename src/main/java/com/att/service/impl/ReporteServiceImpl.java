package com.att.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.att.dao.IReporteDAO;
import com.att.model.Graficos;
import com.att.service.IReporteService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReporteServiceImpl implements IReporteService {

	@Autowired
	private IReporteDAO dao;
	List<Graficos> lista = new ArrayList<>();

	@Override
	public Integer contadorTotalIncidentes() {
		return dao.contadorTotalIncidentes();
	}

	@Override
	public Integer contadorAnalisis() {
		return dao.contadorAnalisis();
	}

	@Override
	public Integer contadorConstruccion() {
		return dao.contadorConstruccion();
	}

	@Override
	public Integer contadorPruebas() {
		return dao.contadorPruebas();
	}

	@Override
	public Integer contadorLiberacion() {
		return dao.contadorLiberacion();
	}

	@Override
	public Integer contadorRetro() {
		return dao.contadorRetro();
	}

	@Override
	public Integer contadorTotalIncidentesTomados() {
		return dao.contadorTotalIncidentesTomados();
	}

	public List<Graficos> datosGrafica() {
		Graficos g = new Graficos();
		g.setAnalisis(this.contadorAnalisis());
		g.setConstruccion(this.contadorConstruccion());
		g.setPruebas(this.contadorPruebas());
		g.setLiberacion(this.contadorLiberacion());
		g.setCierre(this.contadorRetro());
		g.setTotalInc(this.contadorTotalIncidentes());
		g.setTotalIncSel(this.contadorTotalIncidentesTomados());
		lista.add(g);
		return lista;
	}

	@Override
	public byte[] generarReporte() {
		this.datosGrafica();
		byte[] data = null;
		try {
			File file = new ClassPathResource("/reports/inc_rep.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null,
					new JRBeanCollectionDataSource(lista));
			data = JasperExportManager.exportReportToPdf(print);
			lista.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
