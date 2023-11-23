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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipoServicio;

    //@Getter
    //@Setter
    @Column(name="descripcion")
    private String descripcion;

/*
    public void setIdTipoServicio(int idTipoServicio) {this.idTipoServicio=idTipoServicio;}

    public int getIdTipoServicio(){ return idTipoServicio;}

    public String getDescripcion(){return descripcion;}

    public void setDescripcion(String descripcion){this.descripcion=descripcion;}
*/

}
