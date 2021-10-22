package com.att.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inc_pos_reporte")
@SequenceGenerator(name = "seq_rep", sequenceName = "seq_report", allocationSize = 1)
public class Reporte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rep")
	@Column(name = "idReporte")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
