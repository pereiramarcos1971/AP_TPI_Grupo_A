package org.tpi_arg_prog;

import org.tpi_arg_prog.Entidades.*;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Dao.JpaDao;
import org.tpi_arg_prog.Repository.Interfaces.*;
import org.tpi_arg_prog.Repository.JPA.*;
import org.tpi_arg_prog.Servicios.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Dao dao = new JpaDao();

        /* Tipo Problema */

        TipoProblemaRepository tipoProblemaRepository = new JpaTipoProblemaRepository(dao);

        TipoProblemaService tipoProblemaService =new TipoProblemaService(tipoProblemaRepository);

        TipoProblema tp = new TipoProblema();
        tp.setIdTipoProblema(1);
        tp.setDescripcion("Pantalla de inicio no funciona");
        tipoProblemaService.guardarTipoProblema(tp);


        TipoProblema tp2 = new TipoProblema();
        tp2.setIdTipoProblema(2);
        tp2.setDescripcion("Pantalla de fin no funciona");
        tipoProblemaService.guardarTipoProblema(tp2);


        TipoProblema tipoProblemaConsulta = tipoProblemaService.getById(2);
       // tipoProblemaService.borrarTipoProblema(tipoProblemaConsulta);

        System.out.println(tipoProblemaConsulta);

        List<TipoProblema> tipoProblemaTodos = tipoProblemaService.getAll();
        System.out.println("Imprimir todos los tipo de problemas");
        System.out.println(tipoProblemaTodos);


        // ------------------------


        /* Tipo Servicio */
        TipoServicioRepository tipoServicioRepository = new JpaTipoServicioRepository(dao);

        TipoServicioService tipoServicioService =new TipoServicioService(tipoServicioRepository);

        TipoServicio ts = new TipoServicio();
        ts.setIdTipoServicio(1);
        ts.setDescripcion("Aplicaciones");
        tipoServicioService.guardarTipoServicio(ts);

        TipoServicio tipoServicioConsulta = tipoServicioService.getById(1);

        System.out.println( "El getByID" + tipoServicioConsulta);

        List<TipoServicio> tipoServicioTodos = tipoServicioService.getAll();

        System.out.println("Imprimir todos TipoServicios");
        System.out.println(tipoServicioTodos);



        //-------------------------------------- */



        /* Servicio */
        ServicioRepository servicioRepository = new JpaServicioRepository(dao);

        ServicioService servicioService =new ServicioService(servicioRepository);

        Servicio serv = new Servicio();
        serv.setIdServicio(1);
        serv.setDescripcion("Tango 01");
        serv.setTipoServicio(ts);
        servicioService.guardarServicio(serv);

        Servicio serv2 = new Servicio();
        serv2.setIdServicio(2);
        serv2.setDescripcion("Dynamics");
        serv2.setTipoServicio(ts);
        servicioService.guardarServicio(serv2);



        Servicio servicioConsulta = servicioService.getById(1);

        System.out.println( "El getByID" + servicioConsulta);
        List<Servicio> servicioTodos = servicioService.getAll();

        System.out.println("Imprimir todos Servicios");

        System.out.println(servicioTodos);


        // ------------------------ */


        /* Cliente */
        ClienteRepository clienteRepository = new JpaClienteRepository(dao);

        ClienteService clienteService =new ClienteService(clienteRepository);

        Cliente cli = new Cliente();
        cli.setIdCliente(1);
        cli.setRazonSocial("Pereira S.A.");
        cli.setCuit(20452788855L);
        cli.setEmail("marcos.pereira@gmail.com");
        cli.setTelefono("1564579832");
        List<Servicio>serviciosDelCliente = new ArrayList<>();
        serviciosDelCliente.add(serv);
        serviciosDelCliente.add(serv2);

        cli.setServicios(serviciosDelCliente);
        clienteService.guardarCliente(cli);

        Cliente clienteConsulta = clienteService.getById(1);

        System.out.println( "El getByID" + clienteConsulta);
        List<Cliente> clienteTodos = clienteService.getAll();

        System.out.println("Imprimir todos Clientes");

        System.out.println(clienteTodos);


        // ------------------------ */








        /* Tecnico */
        TecnicoRepository tecnicoRepository = new JpaTecnicoRepository(dao);

        TecnicoService tecnicoService =new TecnicoService(tecnicoRepository);

        Tecnico tec = new Tecnico();
        tec.setIdTecnico(1);
        tec.setApellido("De Luca");
        tec.setNombre("Eduardo");
        tec.setEmail("eduardo.deluca@gmail.com");
        tec.setTelefono("1564579832");
        tec.setDisponible(Boolean.TRUE);
        List<Servicio>especialidadesDelTecnico = new ArrayList<>();
        especialidadesDelTecnico.add(serv);
        especialidadesDelTecnico.add(serv2);
        tec.setServicios(especialidadesDelTecnico);
        tecnicoService.guardarTecnico(tec);

        Tecnico tecnicoConsulta = tecnicoService.getById(1);

        System.out.println( "El getByID" + tecnicoConsulta);
        List<Tecnico> tecnicoTodos = tecnicoService.getAll();

        System.out.println("Imprimir todos Tecnicos");

        System.out.println(tecnicoTodos);


        // ------------------------ */


        /* Problema Servicio */
        ProblemaServicioRepository problemaServicioRepository = new JpaProblemaServicioRepository(dao);

        ProblemaServicioService problemaServicioService =new ProblemaServicioService(problemaServicioRepository);

        ProblemaServicio probServ = new ProblemaServicio();
        serv.setIdServicio(1);
        probServ.setTipoProblema(tp);
        probServ.setServicio(serv);
        probServ.setTiempoMaximoResolucion(48);
        problemaServicioService.guardarProblemaServicio(probServ);

        ProblemaServicio problemaServicioConsulta = problemaServicioService.getById(1);

        System.out.println( "El getByID" + problemaServicioConsulta);
        List<ProblemaServicio> servicioProblemaTodos = problemaServicioService.getAll();

        System.out.println("Imprimir todos los ProblemasServicios");

        System.out.println(servicioProblemaTodos);


        // ------------------------ */

        /* Incidente */
        IncidenteRepository incidenteRepository = new JpaIncidenteRepository(dao);

        IncidenteService incidenteService =new IncidenteService(incidenteRepository);

        Incidente inc = new Incidente();
        inc.setId_incidente(1);
        inc.setCliente(cli);
        inc.setServicio(cli.getServicios().get(1));
        inc.setProblemaServicio(probServ);
        inc.setDescripcion("Ademas que no funciona la pantalla de inicio, aparece un mensaje de error");
        inc.setFechaAlta(LocalDateTime.now());

        incidenteService.guardarIncidente(inc);

        Incidente inc2 = new Incidente();
        inc2.setId_incidente(2);
        inc2.setCliente(cli);
        inc2.setServicio(cli.getServicios().get(1));
        inc2.setProblemaServicio(probServ);
        inc2.setDescripcion("Ademas que no funciona la pantalla de inicio, se reinicia la computadora");
        inc2.setFechaAlta(LocalDateTime.now());
        List<Incidente> incidentes = new ArrayList<>();
        incidentes.add(inc);
        inc2.setIncidentesRelacionados(incidentes);
        incidenteService.guardarIncidente(inc2);


        Incidente incidenteConsulta = incidenteService.getById(1);

        System.out.println( "El getByID" + incidenteConsulta);
        List<Incidente> incidenteTodos = incidenteService.getAll();

        System.out.println("Imprimir todos los Incidentes");

        System.out.println(incidenteTodos);


        // ------------------------ */


        /* Incidente Asignado */
        IncidenteAsignadoRepository incidenteAsignadoRepository = new JpaIncidenteAsignadoRepository(dao);

        IncidenteAsignadoService incidenteAsignadoService =new IncidenteAsignadoService(incidenteAsignadoRepository);

        IncidenteAsignado incAsig = new IncidenteAsignado();
        incAsig.setIdIncidenteAsignado(1);
        incAsig.setIncidente(inc);
        List<Integer> tecDisponibles = tecnicoService.getDisponibles();

        Tecnico tecDisp = tecnicoService.getById(tecDisponibles.get(0));
        incAsig.setTecnico(tecDisp);

        incAsig.setTiempoResolucionDefault(48);
        incAsig.setComplejo(true);
        incAsig.setTiempoResolucionAdicional(24);

        incidenteAsignadoService.guardarIncidenteAsignado(incAsig);

        List<IncidenteAsignado> incidenteAsignadoTodos = incidenteAsignadoService.getAll();

        System.out.println("Imprimir todos los Incidentes Asignados");

        System.out.println(incidenteAsignadoTodos);


        // ------------------------ */


    /* Resolucion de incidente*/

        IncidenteAsignado incidenteAsignadoConsulta = incidenteAsignadoService.getById(1);

        System.out.println( "El getByID" + incidenteAsignadoConsulta);

        incidenteAsignadoConsulta.setResuelto(true);
        incidenteAsignadoConsulta.setObservacionesResolucion("Resolucion OK");
        incidenteAsignadoConsulta.setFechaResolucion(LocalDateTime.now());
        incidenteAsignadoService.actualizarIncidenteAsignado(incidenteAsignadoConsulta);

        System.out.println("El incidente: #" + incidenteAsignadoConsulta.getIncidente().getId_incidente() + " fue resuelto");

        // -------------------

        /* Reportes */


        // Reporte  con query

        ReporteTecnicoRepository reporteTecnicoRepository = new JpaReporteTecnicoRepository(dao);

        ReporteTecnicoService reporteTecnicoService =new ReporteTecnicoService(reporteTecnicoRepository);

        List<ReporteTecnico> tecnicoConMasIncidentesResueltosEnNDias = reporteTecnicoService.getTecnicoConMasIncidentesResueltosEnNDias(1);

        System.out.println("Imprimir el Reporte 1");

        tecnicoConMasIncidentesResueltosEnNDias.forEach(resultado->System.out.println(resultado));


        /*
        // Reporte 1
        List<Tecnico> tecnicoConMasIncidentesResueltosEnNDias = tecnicoService.getTecnicoConMasIncidentesResueltosEnNDias(1);

        System.out.println("Imprimir el Reporte 1");

        tecnicoConMasIncidentesResueltosEnNDias.forEach(resultado->System.out.println(resultado));

        */

        //Reporte 2
        List<ReporteTecnico> tecnicoConMasIncidentesResueltosParaServicioEnNDias = reporteTecnicoService.getTecnicoConMasIncidentesResueltosParaServicioEnNDias("Dynamics", 1);

        System.out.println("Imprimir el Reporte 2");

        tecnicoConMasIncidentesResueltosParaServicioEnNDias.forEach(resultado->System.out.println(resultado));



        //Reporte 3
        List<ReporteTecnico> tecnicoMasRapido = reporteTecnicoService.getTecnicoMasRapido();

        System.out.println("Imprimir el Reporte 3");

        tecnicoMasRapido.forEach(resultado->System.out.println(resultado));


    }

 }


