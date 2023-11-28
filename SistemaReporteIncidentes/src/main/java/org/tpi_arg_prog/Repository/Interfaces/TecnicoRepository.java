package org.tpi_arg_prog.Repository.Interfaces;
import org.tpi_arg_prog.Entidades.Tecnico;

import java.util.List;

public interface TecnicoRepository {

    Tecnico getById(int idTecnico);

    List<Integer> getDisponibles();

    void save(Tecnico tecnico);
    void update(Tecnico tecnico);
    void delete(int idTecnico);

    List<Tecnico> getAll();
    List<Tecnico> getTecnicoConMasIncidentesResueltosEnNDias(int dias);

    List<Tecnico> getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias);

    List<Tecnico> getTecnicoMasRapido();





}
