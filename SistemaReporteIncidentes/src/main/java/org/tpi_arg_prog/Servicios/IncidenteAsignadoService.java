package org.tpi_arg_prog.Servicios;
import org.tpi_arg_prog.Entidades.IncidenteAsignado;
import org.tpi_arg_prog.Repository.Interfaces.IncidenteAsignadoRepository;

import java.util.List;

public class IncidenteAsignadoService {


    private final IncidenteAsignadoRepository incidenteAsignadoRepository;

    public IncidenteAsignadoService(IncidenteAsignadoRepository incidenteAsignadoRepository){
        this.incidenteAsignadoRepository=incidenteAsignadoRepository;
    }


    public void guardarIncidenteAsignado(IncidenteAsignado incidenteAsignado) {
        incidenteAsignadoRepository.save(incidenteAsignado);
    }

    public void actualizarIncidenteAsignado(IncidenteAsignado incidenteAsignado){
        incidenteAsignadoRepository.update(incidenteAsignado);
    }
    public IncidenteAsignado getById(int idIncidenteAsignado) {
        return incidenteAsignadoRepository.getById(idIncidenteAsignado);
    }

    public List<IncidenteAsignado> getAll() {
        return incidenteAsignadoRepository.getAll();
    }




}
