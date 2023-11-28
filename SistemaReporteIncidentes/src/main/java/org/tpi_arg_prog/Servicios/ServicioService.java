package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.Servicio;
import org.tpi_arg_prog.Repository.Interfaces.ServicioRepository;

import java.util.List;

public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository){
        this.servicioRepository=servicioRepository;
    }


    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    public Servicio getById(int idServicio) {
        return servicioRepository.getById(idServicio);
    }

    public List<Servicio> getAll() {
        return servicioRepository.getAll();
    }

}
