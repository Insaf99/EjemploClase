package com.example.ClaseSpring.EjemploClase.Dao;

import com.example.ClaseSpring.EjemploClase.Dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);
}
