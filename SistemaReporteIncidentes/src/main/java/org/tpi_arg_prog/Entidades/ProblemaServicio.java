package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="problemas_servicios")
public class ProblemaServicio {

    @Id
    @Column(name="id_problema_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProblemaServcio;

    @ManyToOne()
    @JoinColumn(name="id_tipo_problema", referencedColumnName="id_tipo_problema")
    private TipoProblema tipoProblema;

    @ManyToOne()
    @JoinColumn(name="id_servicio", referencedColumnName="id_servicio")
    private Servicio servicio;

    @Column(name="tiempo_maximo_resolucion")
    private float tiempoMaximoResolucion;


}
