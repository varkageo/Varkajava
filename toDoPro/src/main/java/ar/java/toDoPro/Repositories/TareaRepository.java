package ar.java.toDoPro.Repositories;

import org.springframework.data.repository.CrudRepository;
import ar.java.toDoPro.Models.*;

public interface TareaRepository extends CrudRepository <Tarea, Integer> {
	
	Iterable<Tarea> findByNombre(String nombre);
	Iterable<Tarea> findByNombreContains(String nombre);

}
