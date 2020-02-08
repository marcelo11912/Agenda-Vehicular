package com.agendaVehicular.controlador;

import com.agendaVehicular.modelo.entity.Mantenimiento;
import com.agendaVehicular.modelo.entity.Vehiculo;
import com.agendaVehicular.modelo.service.IMantenimientoService;
import com.agendaVehicular.modelo.service.IVehiculoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoControlador {

    @Autowired
    IVehiculoService vehiculoService;

    @Autowired
    IMantenimientoService mantenimientoService;

    

    @GetMapping("/formMantenimiento/{vehiculoid}")
    public String crear(@PathVariable(value = "vehiculoid") Long vehiculoid, Model modelo, RedirectAttributes flash) {
        Vehiculo vehiculo = vehiculoService.findOne(vehiculoid);;
        if (vehiculo == null) {
            return "redirect:/vehiculo";
        }
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setVehiculo(vehiculo);
        
        modelo.addAttribute("mantenimiento",mantenimiento);
        return "mantenimiento/formMantenimiento";
    }
    @RequestMapping(value = "/formMantenimiento", method = RequestMethod.POST)
    public String guardar(@Valid Mantenimiento mantenimiento, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status) {
        
        if (result.hasErrors()) {
            return "mantenimiento/formMantenimiento" ;
        }

        mantenimientoService.save(mantenimiento);
        status.setComplete();
       
        return "redirect:/verVehiculo/" + mantenimiento.getVehiculo().getIdvehiculo() ;

    }

}























































