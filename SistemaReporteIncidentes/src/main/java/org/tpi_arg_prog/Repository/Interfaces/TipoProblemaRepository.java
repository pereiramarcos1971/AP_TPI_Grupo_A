package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.TipoProblema;

import java.util.List;

public interface TipoProblemaRepository {

    TipoProblema getById(int idTipoProblema);
    List<TipoProblema> getAll();
    void save(TipoProblema tipoProblema);
    void update(TipoProblema tipoProblema);
    void delete(TipoProblema tipoProblema);

}
