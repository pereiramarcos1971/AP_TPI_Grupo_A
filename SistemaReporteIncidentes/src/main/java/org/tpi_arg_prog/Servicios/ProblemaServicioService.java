package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.ProblemaServicio;
import org.tpi_arg_prog.Repository.Interfaces.ProblemaServicioRepository;

import java.util.List;

public class ProblemaServicioService {

    private final ProblemaServicioRepository problemaServicioRepository;

    public ProblemaServicioService(ProblemaServicioRepository problemaServicioRepository){
        this.problemaServicioRepository = problemaServicioRepository;
    }


    public void guardarProblemaServicio(ProblemaServicio problemaServicio) {
        problemaServicioRepository.save(problemaServicio);
    }

    public ProblemaServicio getById(int idProblemaServicio) {
        return problemaServicioRepository.getById(idProblemaServicio);
    }

    public List<ProblemaServicio> getAll() {
        return problemaServicioRepository.getAll();
    }

}
