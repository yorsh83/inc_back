package com.att.service;

public interface IReporteService {

	Integer contadorTotalIncidentes();

	Integer contadorAnalisis();

	Integer contadorConstruccion();

	Integer contadorPruebas();

	Integer contadorLiberacion();

	Integer contadorRetro();

	Integer contadorTotalIncidentesTomados();

	byte[] generarReporte();

}
