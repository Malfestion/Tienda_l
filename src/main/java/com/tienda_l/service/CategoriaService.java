
package com.tienda_l.service;

import com.tienda_l.domain.Categoria;
import java.util.List;

/**
 *
 * @author aledu
 */
public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
    public Categoria getCategoria(Categoria categoria);
    public void save(Categoria categoria);//inserta y actualiza
    public void delete(Categoria categoria);
}
