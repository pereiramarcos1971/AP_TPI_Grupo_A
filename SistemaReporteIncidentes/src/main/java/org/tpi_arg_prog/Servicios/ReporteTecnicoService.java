package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.ReporteTecnico;
import org.tpi_arg_prog.Entidades.Tecnico;
import org.tpi_arg_prog.Repository.Interfaces.ReporteTecnicoRepository;
import org.tpi_arg_prog.Repository.Interfaces.ServicioRepository;

import java.util.List;

public class ReporteTecnicoService {

    private final ReporteTecnicoRepository reporteTecnicoRepository;

    public ReporteTecnicoService(ReporteTecnicoRepository reporteTecnicoRepository){
        this.reporteTecnicoRepository=reporteTecnicoRepository;
    }

    public List<ReporteTecnico> getTecnicoConMasIncidentesResueltosEnNDias(int dias){
        return reporteTecnicoRepository.getTecnicoConMasIncidentesResueltosEnNDias(dias);
    }
    public List<ReporteTecnico> getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias){
        return reporteTecnicoRepository.getTecnicoConMasIncidentesResueltosParaServicioEnNDias(descServicio, dias);
    }

    public List<ReporteTecnico> getTecnicoMasRapido(){
        return reporteTecnicoRepository.getTecnicoMasRapido();
    }


}
