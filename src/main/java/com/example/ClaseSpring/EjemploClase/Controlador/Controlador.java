package com.example.ClaseSpring.EjemploClase.Controlador;

import com.example.ClaseSpring.EjemploClase.Dominio.Persona;
import com.example.ClaseSpring.EjemploClase.Service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@Controller
public class Controlador {

    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping("/")
    public String holamundo(Model model){
        ArrayList<Persona> personas = (ArrayList<Persona>) personaService.listarPersonas();
        model.addAttribute("personas",personas);
        return "Holamundo";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona, Model model){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idpersona}")
    public String editar(Persona persona , Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
