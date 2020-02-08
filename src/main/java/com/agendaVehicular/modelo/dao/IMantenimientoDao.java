
package com.agendaVehicular.modelo.dao;

import com.agendaVehicular.modelo.entity.Mantenimiento;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IMantenimientoDao extends CrudRepository<Mantenimiento,Long> {
   

    
  
}














