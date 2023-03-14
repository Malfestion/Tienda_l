package com.tienda_l.dao;

import com.tienda_l.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aledu
 */
public interface ArticuloDao extends CrudRepository<Articulo,Long>{
    
}
