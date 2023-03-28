package com.tienda_l.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


/**
 *
 * @author aledu
 */
@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_rol")
    private long idRol;//automaticamente sabe que en mysql es id_rol
    @NotEmpty
    private String nombre;

    
}