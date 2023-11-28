package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.TipoServicio;

import java.util.List;

public interface TipoServicioRepository {

    TipoServicio getById(int idTipoServicio);
    List<TipoServicio> getAll();
    void save(TipoServicio tipoServicio);
    void update(TipoServicio tipoServicio);
    void delete(int idTipoServicio);
}
