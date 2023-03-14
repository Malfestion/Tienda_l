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
@Table(name="credito")
public class Credito implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_credito")//dentro de la clase se llama idCredito pero dentro de la tabla se llama id_credito
    private long idCredito;//automaticamente sabe que en mysql es id_cliente
    private double limite;
    

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }


}