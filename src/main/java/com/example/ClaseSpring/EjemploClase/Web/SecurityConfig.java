package com.example.ClaseSpring.EjemploClase.Web;

import com.example.ClaseSpring.EjemploClase.Dominio.Usuario;
import com.example.ClaseSpring.EjemploClase.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    //Autenticacion
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}1234")
                .roles("USER");
    }


    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    //Autorizacion
   /* @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editar/**","/agregar/**","/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/403");
    }*/


}
