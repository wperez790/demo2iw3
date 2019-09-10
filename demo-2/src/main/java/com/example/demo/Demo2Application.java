package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.model.Persona;
import com.example.demo.model.Titulo;
import com.example.demo.persistence.PersonaRepository;
import com.example.demo.persistence.TituloRepository;


@SpringBootApplication
public class Demo2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	
	@Autowired
	private PersonaRepository personaDAO;
	@Autowired
	private TituloRepository tituloDAO;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Titulo t = new Titulo();
		t.setTitulo("Analista de Sistemas");
		List<Titulo> titulos = new ArrayList<>(); 
		titulos.add(t);
		tituloDAO.save(t);
		
		Persona p=new Persona();
		p.setDni(36354790);
		p.setNombre("Walter Gabriel");
		p.setApellido("Perez Sardi");
		Date fecha = Date.valueOf("1992-05-31");
		p.setFecha(fecha);
		p.setTitulos(titulos);
		personaDAO.save(p);
		
	}
	 

}
