package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.TipoProblema;
import org.tpi_arg_prog.Repository.Interfaces.TipoProblemaRepository;

import java.util.List;

public class TipoProblemaService {

    private final TipoProblemaRepository tipoProblemaRepository;

    public TipoProblemaService(TipoProblemaRepository tipoProblemaRepository){
        this.tipoProblemaRepository=tipoProblemaRepository;
    }


    public void guardarTipoProblema(TipoProblema tipoProblema) {
        tipoProblemaRepository.save(tipoProblema);
    }

    public TipoProblema getById(int idTipoProblema) {
        return tipoProblemaRepository.getById(idTipoProblema);
    }

    public List<TipoProblema> getAll() {
        return tipoProblemaRepository.getAll();
    }



}
