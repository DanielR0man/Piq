package co.edu.ufps.service;

import java.util.List;

import co.edu.ufps.model.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	public void insertar(Cliente cliente);
	public Cliente findCliente(Integer id_cliente);
	public void delete(Integer id_cliente);
	
}
