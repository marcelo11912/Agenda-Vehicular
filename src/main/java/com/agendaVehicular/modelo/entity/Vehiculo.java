package com.agendaVehicular.modelo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idvehiculo;

    @NotEmpty
    private String marca;

    @NotEmpty
    private String opt;

    @NotEmpty
    private String tipo;

    @NotEmpty
    private String kilometraje;

    @NotEmpty
    private String placa;


    @OneToMany(mappedBy="vehiculo",fetch= FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Mantenimiento> lista;

    public Vehiculo() {
        lista = new ArrayList();
    }

    public Long getIdvehiculo() {
        return idvehiculo;
    }

    public List<Mantenimiento> getLista() {
        return lista;
    }

    public void setLista(List<Mantenimiento> lista) {
        this.lista = lista;
    }

   

    public void setIdvehiculo(Long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void addMantenimiento(Mantenimiento mantenimiento) {
        lista.add(mantenimiento);

    }
    private static final long serialVersionUID = 1L;

}












