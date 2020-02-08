package com.agendaVehicular.modelo.service;

import com.agendaVehicular.modelo.dao.IVehiculoDao;
import com.agendaVehicular.modelo.entity.Vehiculo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoDao vehiculoDao;

    @Transactional
    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoDao.findAll();
    }

    @Transactional
    @Override
    public Page<Vehiculo> findAll(Pageable pageable) {
        return vehiculoDao.findAll(pageable);
    }

   
    @Override
     @Transactional()
    public void save(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
     @Transactional
    public Vehiculo findOne(Long id) {
        return vehiculoDao.findById(id).orElse(null);
    }

    @Override
     @Transactional
    public void delete(Long id) {
        vehiculoDao.deleteById(id);
    }

}







