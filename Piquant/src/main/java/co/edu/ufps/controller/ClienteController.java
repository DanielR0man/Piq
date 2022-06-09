package co.edu.ufps.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Cliente;
import co.edu.ufps.model.Direccion;
import co.edu.ufps.service.interfac.IAuthorityService;
import co.edu.ufps.service.interfac.IClienteService;
import co.edu.ufps.service.interfac.IDireccionService;


@Controller
@RequestMapping
public class ClienteController {
	
	
	@Autowired
	private  IClienteService clienteService;
	
	@Autowired
	private IDireccionService direccionService;
	
	
	@Autowired
	private IAuthorityService authorityservice;
	
	@PostMapping("/register/save")
	public String registerSave(@ModelAttribute Cliente cliente, @ModelAttribute Direccion direccion) {
		direccionService.insertar(direccion);
		cliente.setDireccion(direccion);
		Set<Authority>authoritys=new HashSet();
		Authority authority= authorityservice.findAuthority(2l);
		authoritys.add(authority);
		System.err.println(authoritys.toString());
		cliente.setAuthority(authoritys);
		clienteService.insertar(cliente);
		return "redirect:/";
	}
	
	
	
	
	
	
}
