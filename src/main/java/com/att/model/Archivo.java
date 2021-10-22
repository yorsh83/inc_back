package com.att.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inc_pos_upload")
@SequenceGenerator(name = "seq_up", sequenceName = "seq_upload", allocationSize = 1)
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_up")
	@Column(name = "id")
	private Integer id;
	@Column(name = "idIncident", length = 100)
	private String idIncident;
	@Column(name = "srid", length = 100)
	private String srid;
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "detailDescription", length = 10000)
	private String detailDescription;
	@Column(name = "status", length = 100)
	private String status;
	@Column(name = "priority", length = 100)
	private String priority;
	@Column(name = "assignedGroup", length = 100)
	private String assignedGroup;
	@Column(name = "assignee", length = 100)
	private String assignee;
	@Column(name = "slmStatus", length = 100)
	private String slmStatus;
	@Column(name = "submitDate")
	private String submitDate;
	@Column(name = "lastModifiedDate")
	private String lastModifiedDate;
	@Column(name = "lastResolvedDate")
	private String lastResolvedDate;
	@Column(name = "usuario", length = 10)
	private String usuario;

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

	public String getSrid() {
		return srid;
	}

	public void setSrid(String srid) {
		this.srid = srid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAssignedGroup() {
		return assignedGroup;
	}

	public void setAssignedGroup(String assignedGroup) {
		this.assignedGroup = assignedGroup;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getSlmStatus() {
		return slmStatus;
	}

	public void setSlmStatus(String slmStatus) {
		this.slmStatus = slmStatus;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastResolvedDate() {
		return lastResolvedDate;
	}

	public void setLastResolvedDate(String lastResolvedDate) {
		this.lastResolvedDate = lastResolvedDate;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
