
package com.tienda_l.service;

import com.tienda_l.domain.Cliente;
import java.util.List;

/**
 *
 * @author aledu
 */
public interface ClienteService {
    public List<Cliente> getClientes();
    public Cliente getCliente(Cliente cliente);
    public void save(Cliente cliente);//inserta y actualiza
    public void delete(Cliente cliente);
}
