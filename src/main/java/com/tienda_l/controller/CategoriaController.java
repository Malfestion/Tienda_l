package com.tienda_l.controller;


import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired//esta etiqueta se da cuenta de que CategoriaService es una interface, entonces busca que clase usa
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String inicio(Model model){
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias",categorias.size());
        return "/categoria/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria){
        return "/categoria/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Model model, Categoria categoria){
        categoria=categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}
