package co.edu.ufps.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.ufps.model.Cliente;
import co.edu.ufps.model.Direccion;
import co.edu.ufps.repository.ClienteRepo;

class ClienteServiceTest {
	
	@Mock
	private ClienteRepo clienteRepo;
	
	@InjectMocks
	private ClienteService clienteService;
	
	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		cliente= new Cliente();
		cliente.setNombre("Yeison");
		cliente.setApellido("Soto");
		cliente.setCelular("320234");
		cliente.setClave("123");
		cliente.setDocumento("123");
		cliente.setDireccion(new Direccion(1,"Cucuta"));
		
	}

	@Test
	void testFindAll() {
		when(clienteRepo.findAll()).thenReturn(Arrays.asList(cliente));
		assertNotNull(clienteService.findAll());
		
	}

	@Test
	void testInsertar() {
		when(clienteRepo.save(cliente)).thenReturn(cliente);

	}

	@Test
	void testFindCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
