package com.example.ClaseSpring.EjemploClase.Service;

import com.example.ClaseSpring.EjemploClase.Dao.PersonaDao;
import com.example.ClaseSpring.EjemploClase.Dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdpersona()).orElse(null);
    }
}
