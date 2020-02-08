
package com.agendaVehicular.modelo.dao;

import com.agendaVehicular.modelo.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IUsuarioDao extends PagingAndSortingRepository<Usuario,String> {
    
}



