package com.tienda_l.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @author aledu
 */
@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_cliente")
    private long idCliente;//automaticamente sabe que en mysql es id_cliente
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    @JoinColumn(name="id_credito",referencedColumnName="id_credito")//relacion
    @ManyToOne//Tipo de relacion
    private Credito credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
    
}