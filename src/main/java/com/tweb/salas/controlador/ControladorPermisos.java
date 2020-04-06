package com.tweb.salas.controlador;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorPermisos   {

    @RequestMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String user() {
        return "testjuser";
    }

    @RequestMapping("/jefeProyecto")
    @PreAuthorize("hasRole('JEFE')")
    public String jefeProyecto() {
        return "testjefe";
    }


}
