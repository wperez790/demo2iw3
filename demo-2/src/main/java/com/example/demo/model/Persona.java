package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	private int dni;
	@Column(length = 20)
	private String nombre;
	@Column(length = 20)
	private String apellido;
	private Date fecha;
	
	@JoinTable(
	name="rel_persona_titulos",
	joinColumns = @JoinColumn(name="FK_PERSONA", nullable = false),
	inverseJoinColumns = @JoinColumn(name="FK_TITULO", nullable = false)
	)
	
	@ManyToMany
	private List<Titulo> titulos;
	
	
	
	
	public int getId() {
		return idPersona;
	}
	public void setId(int id) {
		this.idPersona = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Titulo> getTitulos() {
		return titulos;
	}
	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	} 
	
	

}
