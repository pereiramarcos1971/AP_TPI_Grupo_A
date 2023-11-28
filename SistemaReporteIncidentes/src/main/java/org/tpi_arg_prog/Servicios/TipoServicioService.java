package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.TipoServicio;
import org.tpi_arg_prog.Repository.Interfaces.TipoServicioRepository;

import java.util.List;

public class TipoServicioService {

    private final TipoServicioRepository tipoServicioRepository;

    public TipoServicioService(TipoServicioRepository tipoServicioRepository){
        this.tipoServicioRepository=tipoServicioRepository;
    }


    public void guardarTipoServicio(TipoServicio tipoServicio) {
        tipoServicioRepository.save(tipoServicio);
    }

    public TipoServicio getById(int idTipoServicio) {
        return tipoServicioRepository.getById(idTipoServicio);
    }



    public List<TipoServicio> getAll() {
        return tipoServicioRepository.getAll();
    }


}
