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
@Table(name="articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_articulo")
    private long idArticulo;//automaticamente sabe que en mysql es id_cliente
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    @JoinColumn(name="id_categoria",referencedColumnName="id_categoria")//relacion
    @ManyToOne//Tipo de relacion
    private Categoria categoria;

    public Articulo() {
    }

    public Articulo(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        //this.categoria = categoria;
    }

    
}