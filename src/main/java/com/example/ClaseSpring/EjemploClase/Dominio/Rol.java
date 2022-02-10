package com.example.ClaseSpring.EjemploClase.Dominio;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrol;

    @NotEmpty
    private String nombre;


    public Rol() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdrol() {
        return idrol;
    }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
