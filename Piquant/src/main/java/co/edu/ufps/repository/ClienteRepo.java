package co.edu.ufps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.model.Cliente;

@Repository
public interface ClienteRepo  extends CrudRepository<Cliente, Integer> {

	
}
