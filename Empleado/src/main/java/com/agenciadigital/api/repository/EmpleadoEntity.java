package com.agenciadigital.api.repository;


import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class EmpleadoEntity {


	public EmpleadoEntity(String identificacion, String tipoIdentificacion, String nombres, String apellidos, Timestamp fechaRegistro, String estado) {
		this.identificacion=identificacion;
		this.nombres=nombres;
		this.apellidos=apellidos;	
		this.estado=estado;
		this.tipoIdentificacion=tipoIdentificacion; 
		this.fechaRegistro=fechaRegistro;	
	}
	
	public EmpleadoEntity() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="identificacion")
	private String identificacion;

	@Column(name="nombres")
	private String nombres;

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="estado")
	private String estado;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;
}
