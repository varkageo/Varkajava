package ar.java.toDoPro.DTO;

import java.sql.Date;

public class TareaDTO {

	//Atributos
	String descripcion;
	Integer id;
	Date fechaInicio;
	Date fechaRealizada;
	Integer asignadaA;
	boolean realizada;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaRealizada() {
		return fechaRealizada;
	}
	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}
	public Integer getAsignadaA() {
		return asignadaA;
	}
	public void setAsignadaA(Integer asignadaA) {
		this.asignadaA = asignadaA;
	}
	public boolean isRealizada() {
		return realizada;
	}
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	
	
	
}
