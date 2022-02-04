package com.example.ClaseSpring.EjemploClase.Dao;

import com.example.ClaseSpring.EjemploClase.Dominio.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona,Long> {
}
