package co.edu.ufps.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Categoria;
import co.edu.ufps.model.Cliente;
import co.edu.ufps.model.Direccion;
import co.edu.ufps.model.Producto;
import co.edu.ufps.service.interfac.ICategoriaService;
import co.edu.ufps.service.interfac.IProductoService;

@Controller
@RequestMapping
public class VistasController {
	
	@Autowired
	private IProductoService productoSerive;
	
	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping({"/home","/"})
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		Cliente cliente= new Cliente();
		Direccion direccion = new Direccion();
		model.addAttribute("cliente",cliente);
		model.addAttribute(direccion);
		return "registro";
	}
	
	
	@GetMapping("/menu")
	public String menu(Model model) {
		List<Producto>productos= productoSerive.findAll();
		model.addAttribute("productos",productos);
		System.out.println(productos.toString());
		return "menu";
	}
	
	@GetMapping("/admincate")
	public String admincate(Model model) {
		List<Categoria>categorias= categoriaService.findAll();
		Categoria categoria= new Categoria();
		model.addAttribute("categorias",categorias);
		model.addAttribute("categor",categoria);
		return "admincategoria";
	}
	
	@GetMapping("/adminproduc")
	public String adminproduc(Model model) {
		Producto producto = new Producto();
		List<Producto>productos= productoSerive.findAll();
		List<Categoria>categorias= categoriaService.findAll();
		model.addAttribute("producto",producto);
		model.addAttribute("productos",productos);
		model.addAttribute("categorias",categorias);
		return "adminproducto";
	}
	
	@GetMapping("/estadisticas")
	public String estadisticas() {
		
		return "estadisticas";
	}
	
	@GetMapping("/carrito")
	public String carrito() {
		
		return "carrito";
	}
	
	
}
