package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="titulos")
public class Titulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTitulo; 
	@Column(length = 35)
	private String titulo;
	@ManyToMany(mappedBy="titulosPersona")
	//Set<Persona> personasConTitulo;
	private List<Persona> personas;
	
	public int getIdTitulo() {
		return idTitulo;
	}
	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}
