package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel, String> {

	ArrayList<ClienteModel> findByNombre(String nombre);

	@Query(value = "{'nombre':?0, 'apellido':?1}")
	ArrayList<ClienteModel> clientesByNombreApellido(String nombre, String apellido);

	@Query(value = "{'address.ciudad':?0}", fields = "{'nombre':1,'apellido':1}")
	ArrayList<ClienteModel> clientesByCiudad(String ciudad);

	ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);

	ArrayList<ClienteModel> findByPuntosLessThanEqual(Long puntos);

}
