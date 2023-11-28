package org.tpi_arg_prog.Repository.Interfaces;

import org.tpi_arg_prog.Entidades.Cliente;

import java.util.List;

public interface ClienteRepository {

    Cliente getById(int idCliente);
    List<Cliente> getAll();
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(int idCliente);


}
