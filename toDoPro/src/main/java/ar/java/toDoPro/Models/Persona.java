package ar.java.toDoPro.Models;

import javax.persistence.*;

@Entity
public class Persona {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 
	 Integer id;
	 String nombre;
	 String apellido;
	
	 
	 
	 
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	 
	 
	 
	
	

}
