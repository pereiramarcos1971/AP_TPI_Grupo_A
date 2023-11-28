package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.Incidente;
import org.tpi_arg_prog.Repository.Interfaces.IncidenteRepository;

import java.util.List;

public class IncidenteService {


    private final IncidenteRepository incidenteRepository;

    public IncidenteService(IncidenteRepository incidenteRepository){
        this.incidenteRepository=incidenteRepository;
    }


    public void guardarIncidente(Incidente incidente) {
        incidenteRepository.save(incidente);
    }

    public void actualizarIncidente(Incidente incidente){
        incidenteRepository.update(incidente);
    }

    public Incidente getById(int idIncidente) {
        return incidenteRepository.getById(idIncidente);
    }

    public List<Incidente> getAll() {
        return incidenteRepository.getAll();
    }



}
