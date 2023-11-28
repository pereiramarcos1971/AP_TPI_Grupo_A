package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ReporteTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tecnico")
    private int idTecnico;

    @Column(name="apellido")
    private String apellido;

    @Column(name="nombre")
    private String nombre;

    @Column(name="cant_incidentes")
    private int cantIncidentes;

}
