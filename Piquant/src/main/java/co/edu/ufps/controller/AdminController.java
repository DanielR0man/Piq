package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.ufps.model.Categoria;
import co.edu.ufps.model.Producto;
import co.edu.ufps.service.ICategoriaService;
import co.edu.ufps.service.IProductoService;

@Controller
public class AdminController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IProductoService productoService;

	@PostMapping("/insertarCategoria")
	public String insertarCatego(@ModelAttribute Categoria categoria) {
		categoriaService.insertar(categoria);
		System.out.println(categoria);
		return "redirect:/admincate";
	}
	
	@PostMapping("/insertarProducto")
	public String insertarProducto(@ModelAttribute Producto producto) {
		productoService.insertar(producto);
		return "redirect:/adminproduc";
	}
	
	@GetMapping("/editarCatego/{id}")
	public String editarCategoria(@PathVariable("id")Integer idCate, Model model ) {
		
		Categoria categoria= categoriaService.findCategoria(idCate);
		System.out.println(categoria.toString());
		model.addAttribute("categor",categoria);
		
		return "redirect:/admincate";
	}
}
