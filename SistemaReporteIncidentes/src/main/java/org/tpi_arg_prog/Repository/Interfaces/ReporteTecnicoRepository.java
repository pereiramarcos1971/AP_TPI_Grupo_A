package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.ReporteTecnico;
import org.tpi_arg_prog.Entidades.Tecnico;

import java.util.List;

public interface ReporteTecnicoRepository {

    List<ReporteTecnico> getTecnicoConMasIncidentesResueltosEnNDias(int dias);

    List<ReporteTecnico> getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias);

    List<ReporteTecnico> getTecnicoMasRapido();


}
