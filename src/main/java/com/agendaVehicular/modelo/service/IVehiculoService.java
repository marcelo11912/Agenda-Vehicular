
package com.agendaVehicular.modelo.service;

import com.agendaVehicular.modelo.entity.Vehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IVehiculoService {
    public List<Vehiculo> findAll();
    public Page<Vehiculo> findAll(Pageable pageable);

    public void save(Vehiculo vehiculo);

    public Vehiculo findOne(Long id);

    public void delete(Long id);
}






