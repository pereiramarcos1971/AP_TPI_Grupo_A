package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.Cliente;
import org.tpi_arg_prog.Entidades.Servicio;

import java.util.List;

public interface ServicioRepository {

    Servicio getById(int idServicio);
    List<Servicio> getAll();
    void save(Servicio servicio);
    void update(Servicio servicio);
    void delete(int idServicio);

}
