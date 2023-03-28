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
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;//numero en el que inicia el incremental
    //llave primaria de la base de datos:
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//java no genera el numero, lo genera mysql
    @Column(name="id_usuario")
    private long idUsuario;//automaticamente sabe que en mysql es id_usuario
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
 
    @JoinColumn(name="id_usuario",referencedColumnName="id_usuario")//relacion
    @OneToMany//Tipo de relacion
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
}