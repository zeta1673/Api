package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
	ArrayList<ClienteModel>findByNombre (String nombre);
	
	@Query("{'address.ciudad':?0}")
	ArrayList<ClienteModel> clientesByCiudad(String ciudad, String departamento);
	
	ArrayList<ClienteModel>findByPuntosGreaterThanEqual(Long puntos);
	

}

