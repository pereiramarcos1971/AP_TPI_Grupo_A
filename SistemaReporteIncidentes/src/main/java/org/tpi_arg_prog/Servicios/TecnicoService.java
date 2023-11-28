package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.Tecnico;
import org.tpi_arg_prog.Repository.Interfaces.TecnicoRepository;

import java.util.List;

public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository){
        this.tecnicoRepository=tecnicoRepository;
    }


    public void guardarTecnico(Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
    }

    public Tecnico getById(int idTecnico) {
        return tecnicoRepository.getById(idTecnico);
    }

    public List<Tecnico> getAll() {
        return tecnicoRepository.getAll();
    }

    public List<Tecnico> getTecnicoConMasIncidentesResueltosEnNDias(int dias){
        return tecnicoRepository.getTecnicoConMasIncidentesResueltosEnNDias(dias);
    }

    public List<Tecnico> getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias){
        return tecnicoRepository.getTecnicoConMasIncidentesResueltosParaServicioEnNDias(descServicio, dias);
    }

    public List<Tecnico> getTecnicoMasRapido(){
        return tecnicoRepository.getTecnicoMasRapido();
    }



    public List<Integer> getDisponibles(){
        return  tecnicoRepository.getDisponibles();
    }

    }

