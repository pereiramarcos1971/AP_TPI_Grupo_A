package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.Incidente;
import org.tpi_arg_prog.Entidades.IncidenteAsignado;

import java.util.List;

public interface IncidenteAsignadoRepository {

    IncidenteAsignado getById(int idIncidenteAsignado);
    List<IncidenteAsignado> getAll();
    void save(IncidenteAsignado incidenteAsignado);
    void update(IncidenteAsignado incidenteAsignado);
    void delete(int idIncidenteAsignado);

}
