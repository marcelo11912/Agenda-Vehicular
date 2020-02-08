
package com.agendaVehicular.modelo.dao;

import com.agendaVehicular.modelo.entity.Vehiculo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;


public interface IVehiculoDao extends PagingAndSortingRepository<Vehiculo,Long> {
    
}







