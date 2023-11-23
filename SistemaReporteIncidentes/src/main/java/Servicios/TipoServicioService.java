package Servicios;

import Entidades.TipoServicio;
import Repository.TipoServicioRepository;

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

    public List<TipoServicio> getAll(String descripcion) {
        return tipoServicioRepository.getAll();
    }


}
