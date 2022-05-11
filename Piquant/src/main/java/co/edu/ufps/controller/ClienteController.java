package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import co.edu.ufps.model.Cliente;
import co.edu.ufps.model.Direccion;
import co.edu.ufps.service.IClienteService;
import co.edu.ufps.service.IDireccionService;


@Controller
@RequestMapping
public class ClienteController {
	
	
	@Autowired
	private  IClienteService clienteService;
	
	@Autowired
	private IDireccionService direccionService;
	

	
	@GetMapping("/formLogin")
	public String registrarCliente(Model model) {
		Cliente cliente= new Cliente();	
		Direccion direccion = new Direccion();
		model.addAttribute(cliente);
		model.addAttribute(direccion);
		return "registro";
	}
	
	@PostMapping("/formLogin/insertar")
	public String registrarCliente(@ModelAttribute Cliente cliente, @ModelAttribute Direccion direccion) {
		direccionService.insertar(direccion);
		cliente.setDireccion(direccion);
		clienteService.insertar(cliente);
		return "redirect:/";
	}
	
	@PostMapping("/formularioIngresar/login")
	public String login(@ModelAttribute Cliente cliente) {
		
		List<Cliente>clientes= clienteService.findAll();
		System.out.println(cliente.getCorreo() + cliente.getClave());
		if(cliente.getCorreo().equals("admin") && cliente.getClave().equals("123"))
		{
			return "redirect:/admincate";
		}
		
		for (Cliente c : clientes) {
			System.out.println(c.toString());
			if(c.getCorreo().equals(cliente.getCorreo()) && c.getClave().equals(cliente.getClave())  ) {
				return "redirect:/";
			}
		}
		
		return "redirect:/formularioIngresar";
	}
	
	@GetMapping("/formularioIngresar")
	public String formLogin(Model model) {
		Cliente cliente= new Cliente();
		model.addAttribute("cliente",cliente);
		return "login";
	}
	
	
	
}
