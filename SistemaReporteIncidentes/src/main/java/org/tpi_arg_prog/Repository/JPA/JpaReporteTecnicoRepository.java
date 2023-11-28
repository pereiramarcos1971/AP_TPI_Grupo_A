package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.ReporteTecnico;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.ReporteTecnicoRepository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class JpaReporteTecnicoRepository implements ReporteTecnicoRepository {

    private final Dao dao;

    public JpaReporteTecnicoRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List getTecnicoConMasIncidentesResueltosEnNDias(int dias) {

        System.out.println("Reporte1 de los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            String sql = "SELECT t.id_tecnico, t.apellido, t.nombre,  COUNT(ia.id_incidente) as cant_incidentes\n" +
                    "    FROM tecnicos t\n" +
                    "    INNER JOIN incidentes_asignados ia ON t.id_tecnico = ia.id_tecnico\n" +
                    "    WHERE ia.marca_resolucion = 1 and datediff(now(), ia.fecha_resolucion) <= ?1\n" +
                    "    GROUP BY t.id_tecnico, t.apellido, t.nombre ORDER BY COUNT(ia.id_incidente) DESC\n" +
                    "    limit 1";

            Query query = entityManager.createNativeQuery(sql, ReporteTecnico.class);
            query.setParameter(1, dias);
            return query.getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias) {

        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("tecnico_mas_incidentes_resueltos_de_un_servicio_en_n_dias");
            storedProcedure.registerStoredProcedureParameter("descripcion_servicio", String.class, ParameterMode.IN);
            storedProcedure.setParameter("descripcion_servicio", descServicio);
            storedProcedure.registerStoredProcedureParameter("dias", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("dias", dias);
            storedProcedure.execute();
            return storedProcedure.getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List getTecnicoMasRapido() {

        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("tecnico_mas_rapido");
            storedProcedure.execute();
            return storedProcedure.getResultList();

        } finally {
            entityManager.close();
        }
    }


}
