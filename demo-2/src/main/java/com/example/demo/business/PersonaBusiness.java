package com.example.demo.business;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.persistence.PersonaRepository;;

@Service
public class PersonaBusiness implements IPersonaBusiness {

	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonaRepository personaDAO;
	
	public PersonaBusiness() {
		
	}
	
	@Override
	public List<Persona> list() throws BusinessException {
		try {
			return personaDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BusinessException(e);
		}
	}

	@Override
	public Persona load(int idPersona) throws BusinessException, NotFoundException {
		Optional<Persona> op = null;
		try {
			op = personaDAO.findById(idPersona);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent())
			throw new NotFoundException("No se encuentra la Persona con id=" + idPersona);
		return op.get();
	}

	@Override
	public Persona save(Persona persona) throws BusinessException {
		try {
			return personaDAO.save(persona);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void remove(int idPersona) throws BusinessException, NotFoundException {
		Optional<Persona> op = null;
		try {
			op = personaDAO.findById(idPersona);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		if (!op.isPresent())
			throw new NotFoundException("No se encuentra la persona con id=" + idPersona);
		try {
			personaDAO.deleteById(idPersona);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

}
