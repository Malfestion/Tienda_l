/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_l.service.impl;

import com.tienda_l.dao.ArticuloDao;
import com.tienda_l.domain.Articulo;
import com.tienda_l.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aledu
 */
@Service
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired//Debe haber 1 solo objeto ArticuloDao, si ya existe se usa y si no existe se crea automaticamente sin usar new.
    private ArticuloDao articuloDao;
   
    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)articuloDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Transactional(readOnly=true)
    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
}
