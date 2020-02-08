package com.agendaVehicular.modelo.service;

import com.agendaVehicular.modelo.dao.IMantenimientoDao;
import com.agendaVehicular.modelo.entity.Mantenimiento;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MantenimientoServiceImpl implements IMantenimientoService {

    @Autowired
    IMantenimientoDao mantenimientoDao;

    @Transactional
    @Override
    
    public List<Mantenimiento> findAll() {
        return (List<Mantenimiento>) mantenimientoDao.findAll();
    }

    @Transactional
    @Override
    public void save(Mantenimiento mantenimiento) {
       mantenimientoDao.save(mantenimiento);
    }

    @Transactional
    @Override
    public Mantenimiento findOne(Long id) {
       return mantenimientoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
       mantenimientoDao.deleteById(id);
    }

    @Override
    public Page<Mantenimiento> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  
   

 
}




















