package com.tienda_l.controller;


import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aledu
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired//esta etiqueta se da cuenta de que ClienteService es una interface, entonces busca que clase usa
    private ClienteService clienteService;
    
    @GetMapping("/listado")
    public String inicio(Model model){
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes",clientes.size());
        var totalCredito=0;
        for(Cliente c: clientes){
            totalCredito+=c.getCredito().getLimite();
        }
        model.addAttribute("totalCredito", totalCredito);
        return "/cliente/listado";
    }
    
    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente){
        return "/cliente/modifica";
    }
    
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Model model, Cliente cliente){
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }
}
