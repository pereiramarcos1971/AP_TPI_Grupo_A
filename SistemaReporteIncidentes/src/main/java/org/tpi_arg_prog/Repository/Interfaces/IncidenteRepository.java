package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.Cliente;
import org.tpi_arg_prog.Entidades.Incidente;

import java.util.List;

public interface IncidenteRepository {

    Incidente getById(int idIncidente);
    List<Incidente> getAll();
    void save(Incidente incidente);
    void update(Incidente incidente);
    void delete(int idIncidente);



}
