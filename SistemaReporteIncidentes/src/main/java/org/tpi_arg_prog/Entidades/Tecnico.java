package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="tecnicos")
public class Tecnico {

    @Id
    @Column(name="id_tecnico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnico;

    @Column(name="apellido")
    private String apellido;

    @Column(name="nombre")
    private String nombre;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="disponible")
    private Boolean disponible;

    @ManyToMany
    @JoinTable(name = "tecnicos_especialidades",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> servicios = new ArrayList<>();


}
