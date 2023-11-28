package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.ProblemaServicio;
import org.tpi_arg_prog.Entidades.Servicio;

import java.util.List;

public interface ProblemaServicioRepository {

    ProblemaServicio getById(int idProblemaServicio);
    List<ProblemaServicio> getAll();
    void save(ProblemaServicio problemaServicio);
    void update(ProblemaServicio problemaServicio);
    void delete(int idProblemaServicio);


}
