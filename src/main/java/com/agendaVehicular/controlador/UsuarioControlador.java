package com.agendaVehicular.controlador;

import com.agendaVehicular.modelo.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioControlador {
    

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String index(Model modelo) {
        modelo.addAttribute("titulo", "Agenda de Mantenimiento Vehicular ");
        return "index";

    }
    

   
    
    

}













