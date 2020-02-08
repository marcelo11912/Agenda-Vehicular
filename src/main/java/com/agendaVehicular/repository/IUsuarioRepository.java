
package com.agendaVehicular.repository;

import com.agendaVehicular.modelo.entity.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
    public Optional<Usuario> findByUsername(String username);
    
}








