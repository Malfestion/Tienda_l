package com.tienda_l.dao;

import com.tienda_l.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aledu
 */
public interface CreditoDao extends CrudRepository<Credito,Long>{
    
}
