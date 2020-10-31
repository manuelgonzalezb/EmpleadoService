package com.agenciadigital.service.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entidad de negocio de los empleados
 */
@ApiModel(description = "Contiene la información de los empleados")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-30T18:51:10.375-05:00[America/Bogota]")
public class Empleado {

	@JsonProperty("id")
	private int id;

	@JsonProperty("identificacion")
	private String identificacion;

	@JsonProperty("nombres")
	private String nombres;

	@JsonProperty("apellidos")
	private String apellidos;

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("fechaCreacion")
	@JsonDeserialize(using = com.agenciadigital.api.util.LocalDateTimeDeserializer.class)
	@JsonSerialize(using = com.agenciadigital.api.util.LocalDateTimeSerializer.class)
	private LocalDateTime fechaRegistro;

	@JsonProperty("tipoIdentificacion")
	private String tipoIdentificacion;

	public Empleado id(int id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@ApiModelProperty(required = false, value = "")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado identificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	/**
	 * Get identificacion
	 * 
	 * @return identificacion
	 */
	@ApiModelProperty(value = "")

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Empleado nombres(String nombres) {
		this.nombres = nombres;
		return this;
	}

	/**
	 * Nombres del empleado.
	 * 
	 * @return nombres
	 */
	@ApiModelProperty(value = "Nombres del empleado.")

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Empleado apellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	/**
	 * Apellidos.
	 * 
	 * @return apellidos
	 */
	@ApiModelProperty(value = "Apellidos.")

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Empleado estado(String estado) {
		this.estado = estado;
		return this;
	}

	/**
	 * Get estado
	 * 
	 * @return estado
	 */
	@ApiModelProperty(value = "")

	@Valid

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public Empleado tipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}

	/**
	 * Get tipoIdentificacion
	 * 
	 * @return tipoIdentificacion
	 */
	@ApiModelProperty(value = "")

	@Valid

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	public Empleado fechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
		return this;
	}

	/**
	 * Fecha de creación del empleado
	 * 
	 * @return fechaCreacion
	 */
	@ApiModelProperty(value = "Fecha de creación del empleado")

	@Valid

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Empleado empleado = (Empleado) o;
		return Objects.equals(this.id, empleado.id) && Objects.equals(this.identificacion, empleado.identificacion)
				&& Objects.equals(this.nombres, empleado.nombres) && Objects.equals(this.apellidos, empleado.apellidos)
				&& Objects.equals(this.estado, empleado.estado)
				&& Objects.equals(this.tipoIdentificacion, empleado.tipoIdentificacion)
				&& Objects.equals(this.fechaRegistro, empleado.fechaRegistro);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identificacion, nombres, apellidos, estado,
				tipoIdentificacion, fechaRegistro);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
		sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
		sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
		sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
		sb.append("    tipoIdentificacion: ").append(toIndentedString(tipoIdentificacion)).append("\n");
		sb.append("    fechaRegistro: ").append(toIndentedString(fechaRegistro)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
