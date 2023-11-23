import Entidades.TipoServicio;
import Repository.Dao.Dao;
import Repository.Dao.JpaDao;
import Repository.JpaTipoServicioRepository;
import Repository.TipoServicioRepository;
import Servicios.TipoServicioService;

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