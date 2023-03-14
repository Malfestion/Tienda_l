/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_l.service.impl;

import com.tienda_l.dao.ClienteDao;
import com.tienda_l.dao.CreditoDao;
import com.tienda_l.domain.Cliente;
import com.tienda_l.domain.Credito;
import com.tienda_l.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aledu
 */
@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired//Debe haber 1 solo objeto ClienteDao, si ya existe se usa y si no existe se crea automaticamente sin usar new.
    private ClienteDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    @Transactional(readOnly=true)
    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
