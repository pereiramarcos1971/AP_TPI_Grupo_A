package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="incidentes")
public class Incidente {

    @Id
    @Column(name="id_incidente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_incidente;

    @ManyToOne()
    @JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name="id_servicio", referencedColumnName="id_servicio")
    private Servicio servicio;

    @ManyToOne()
    @JoinColumn(name="id_problema_servicio", referencedColumnName="id_problema_servicio")
    private ProblemaServicio problemaServicio;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_alta")
    private LocalDateTime fechaAlta;

    @ManyToMany
    @JoinTable(name = "incidentes_relacionados",
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_incidente_relacionado"))
    private List<Incidente> incidentesRelacionados = new ArrayList<>();


}
