package com.example.ClaseSpring.EjemploClase.Controlador;

import com.example.ClaseSpring.EjemploClase.Dominio.Persona;
import com.example.ClaseSpring.EjemploClase.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class Controlador {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String holamundo(Model model){
        ArrayList<Persona> personas = (ArrayList<Persona>) personaService.listarPersonas();
        model.addAttribute("personas",personas);
        return "Holamundo";
    }
    // persona.getName()
}
