package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Integer> {

}
