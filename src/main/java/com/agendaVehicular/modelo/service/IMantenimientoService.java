
package com.agendaVehicular.modelo.service;

import com.agendaVehicular.modelo.entity.Mantenimiento;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IMantenimientoService {
    

    public List<Mantenimiento> findAll();
    
    
    public Page<Mantenimiento> findAll(Pageable pageable);

    public void save(Mantenimiento mantenimiento);

    public Mantenimiento findOne(Long id);

    public void delete(Long id);
   
    
}













