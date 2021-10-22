package com.att.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inc_pos_kanban")
@SequenceGenerator(name = "seq_ka", sequenceName = "seq_kanban", allocationSize = 1)
public class Kanban {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ka")
	@Column(name = "id")
	private Integer id;
	@Column(name = "idIncident", length = 100)
	private String idIncident;
	@Column(name = "detail", length = 10000)
	private String detail;
	@Column(name = "priority", length = 100)
	private String priority;
	@Column(name = "lastModifiedDate")
	private String lastModifiedDate;
	@Column(name = "statusKanban")
	private String statusKanban;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "idArchivo")
	private Integer idArchivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdIncident() {
		return idIncident;
	}

	public void setIdIncident(String idIncident) {
		this.idIncident = idIncident;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getStatusKanban() {
		return statusKanban;
	}

	public void setStatusKanban(String statusKanban) {
		this.statusKanban = statusKanban;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

}
