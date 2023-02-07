package com.tienda_l.controller;

import com.tienda_l.dao.ClienteDao;
import com.tienda_l.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aledu
 */
@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        var variable="Hola desde el back-End";
        model.addAttribute("mensaje", variable);
        
        var clientes=clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
