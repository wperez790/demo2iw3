package com.example.demo.business;

import java.util.List;

import com.example.demo.model.Persona;

public interface IPersonaBusiness {

	
	public List<Persona> list() throws BusinessException;

	public Persona load(int idPersona) throws BusinessException, NotFoundException;

	public Persona save(Persona persona) throws BusinessException;

	public void remove(int idPersona) throws BusinessException, NotFoundException;

}
