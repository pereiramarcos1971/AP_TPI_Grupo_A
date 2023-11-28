package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="incidentes_asignados")
public class IncidenteAsignado {

    @Id
    @Column(name="id_incidente_asignado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidenteAsignado;

    @ManyToOne()
    @JoinColumn(name="id_incidente", referencedColumnName="id_incidente")
    private Incidente incidente;

    @ManyToOne()
    @JoinColumn(name="id_tecnico", referencedColumnName = "id_tecnico")
    private Tecnico tecnico;

    @Column(name="tiempo_resolucion_default")
    private float tiempoResolucionDefault;

    @Column(name="complejo")
    private boolean complejo;

    @Column(name="tiempo_resolucion_adicional")
    private float tiempoResolucionAdicional;

    @Column(name="marca_resolucion")
    private boolean resuelto;

    @Column(name="observaciones_resolucion")
    private String observacionesResolucion;

    @Column(name="fecha_resolucion")
    private LocalDateTime fechaResolucion;


}
