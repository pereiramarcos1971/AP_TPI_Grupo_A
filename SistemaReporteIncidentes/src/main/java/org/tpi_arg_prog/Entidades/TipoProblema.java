package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="tipos_problema")
public class TipoProblema {


    @Id
    @Column(name = "id_tipo_problema")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoProblema;

    @Column(name="descripcion")
    private String descripcion;






}
