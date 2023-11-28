package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="clientes")

public class Cliente {

    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name="razon_social")
    private String razonSocial;

    @Column(name="cuit")
    private Long cuit;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @ManyToMany
    @JoinTable(name = "servicios_clientes",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> servicios = new ArrayList<>();


}
