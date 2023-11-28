package org.tpi_arg_prog.Entidades;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="servicios")
public class Servicio {

    @Id
    @Column(name="id_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    @Column(name="descripcion")
    private String descripcion;


    @ManyToOne()
    @JoinColumn(name="id_tipo_servicio", referencedColumnName="id_tipo_servicio")
    private TipoServicio tipoServicio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_servicio")
    private List<ProblemaServicio> problemasServicios= new ArrayList<>();

    @ManyToMany(mappedBy = "servicios")
    private List<Cliente> clientes;

    @ManyToMany(mappedBy = "servicios")
    private List<Tecnico> tecnicos;




}
