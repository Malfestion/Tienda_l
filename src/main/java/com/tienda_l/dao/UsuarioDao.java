package com.tienda_l.dao;

import com.tienda_l.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aledu
 */
public interface UsuarioDao extends CrudRepository<Usuario,Long>{
    Usuario findByUsername(String username);
}
