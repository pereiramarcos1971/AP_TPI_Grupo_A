package org.tpi_arg_prog.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="tipos_servicios")
public class TipoServicio {

    @Id
    @Column(name = "id_tipo_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoServicio;

    @Column(name="descripcion")
    private String descripcion;

}
