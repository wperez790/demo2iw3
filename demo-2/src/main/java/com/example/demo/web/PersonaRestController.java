package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.BusinessException;
import com.example.demo.business.IPersonaBusiness;
import com.example.demo.business.NotFoundException;
import com.example.demo.model.Persona;

@RestController
@RequestMapping(Constantes.URL_BASE_PERSONAS)
public class PersonaRestController {

	@Autowired
	private IPersonaBusiness PersonaBusiness;

	@GetMapping("")
	public ResponseEntity<List<Persona>> list() {
		try {
			return new ResponseEntity<List<Persona>>(PersonaBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Persona> load(@PathVariable("id") int idPersona) {
		try {
			return new ResponseEntity<Persona>(PersonaBusiness.load(idPersona), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<String> insert(@RequestBody Persona Persona) {
		try {
			PersonaBusiness.save(Persona);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_BASE_PERSONAS + "/" + Persona.getId());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "")
	public ResponseEntity<String> update(@RequestBody Persona Persona) {
		try {
			PersonaBusiness.save(Persona);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int idPersona) {
		try {
			PersonaBusiness.remove(idPersona);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
