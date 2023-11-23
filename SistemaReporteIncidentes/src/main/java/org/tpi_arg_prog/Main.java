package org.tpi_arg_prog;

import org.tpi_arg_prog.Entidades.TipoServicio;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Dao.JpaDao;
import org.tpi_arg_prog.Repository.JpaTipoServicioRepository;
import org.tpi_arg_prog.Repository.TipoServicioRepository;
import org.tpi_arg_prog.Servicios.TipoServicioService;

public class Main {
    public static void main(String[] args) {

        Dao dao = new JpaDao();
        TipoServicioRepository tipoServicioRepository = new JpaTipoServicioRepository(dao);

        TipoServicioService tipoServicioService =new TipoServicioService(tipoServicioRepository);

        TipoServicio ts = new TipoServicio();
        ts.setIdTipoServicio(1);
        ts.setDescripcion("Aplicaciones");
        tipoServicioService.guardarTipoServicio(ts);

        TipoServicio tipoServicioConsulta = tipoServicioService.getById(1);
        System.out.println(tipoServicioConsulta.getDescripcion());


    }



}