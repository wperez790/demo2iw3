package com.example.demo.business;

import java.util.List;

import com.example.demo.model.Titulo;

public interface ITituloBusiness {
	
	public List<Titulo> list() throws BusinessException;

	public Titulo load(int idTitulo) throws BusinessException, NotFoundException;

	public Titulo save(Titulo titulo) throws BusinessException;

	public void remove(int idTitulo) throws BusinessException, NotFoundException;

}