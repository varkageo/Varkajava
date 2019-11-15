package ar.java.toDoPro.Models;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Tarea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	String descripcion;
	
	Date fechaInicio;
	Date fechaRealizada;
	Integer asignadaA;
	boolean realizada;
	boolean borrado;
	
	
	public boolean isBorrado() {
		return borrado;
	}
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
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
