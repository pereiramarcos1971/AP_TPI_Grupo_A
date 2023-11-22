package org.arg_prog.Entidades;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tipos_servicios")
public class TipoServicio {

    @Id
    @Getter
    @Setter
    @Column(name = "id_tipo_servicio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipoServicio;

    @Getter
    @Setter
    @Column(name="descripcion")
    private String descripcion;



}
