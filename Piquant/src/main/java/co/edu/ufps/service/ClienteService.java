package co.edu.ufps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Cliente;
import co.edu.ufps.repository.ClienteRepo;

@Service
public class ClienteService implements IClienteService{
	
	
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	

	@Override
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	public void insertar(Cliente cliente) {
		clienteRepo.save(cliente);
		
	}

	@Override
	public Cliente findCliente(Integer id_cliente) {
		
		return clienteRepo.findById(id_cliente).orElse(null);
	}

	@Override
	public void delete(Integer id_cliente) {
		clienteRepo.deleteById(id_cliente);
		
	}

}
