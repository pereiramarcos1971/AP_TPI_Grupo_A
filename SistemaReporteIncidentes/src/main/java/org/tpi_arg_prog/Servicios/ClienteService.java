package org.tpi_arg_prog.Servicios;

import org.tpi_arg_prog.Entidades.Cliente;
import org.tpi_arg_prog.Repository.Interfaces.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }


    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente getById(int idCliente) {
        return clienteRepository.getById(idCliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.getAll();
    }


}
