package com.example.ClaseSpring.EjemploClase.Web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String [] args){
        String password="1234";
        System.out.println("password: "+ password);
        System.out.println("password encriptado: "+ Encriptarpassword(password));
    }

    public static String Encriptarpassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
