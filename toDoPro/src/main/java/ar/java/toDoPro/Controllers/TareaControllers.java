package ar.java.toDoPro.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ar.java.toDoPro.Repositories.*;
import ar.java.toDoPro.DTO.*;
import ar.java.toDoPro.Models.*;
import java.util.*;

import java.lang.*;
@RestController
@RequestMapping("tarea")
public class TareaControllers {
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@GetMapping("/")
	public ArrayList<TareaDTO> listarTodas(){
		
		TareaDTO tareaDTO;
		Tarea unaTarea;
		
		ArrayList<TareaDTO> respuesta = new ArrayList<TareaDTO>();
		Iterable<Tarea> listaTareas;
		
		listaTareas = this.tareaRepository.findAll();
		
		Iterator<Tarea> it = listaTareas.iterator();
		while(it.hasNext()) {
			
			
			unaTarea = it.next();
			
			tareaDTO = new TareaDTO();
			
			tareaDTO.setAsignadaA(unaTarea.getAsignadaA());
			tareaDTO.setDescripcion(unaTarea.getDescripcion());
			tareaDTO.setFechaInicio(unaTarea.getFechaInicio());
			tareaDTO.setFechaRealizada(unaTarea.getFechaRealizada());
			tareaDTO.setRealizada(unaTarea.isRealizada());

		}
		
		return respuesta;
	}	
	
	
	@GetMapping("/{id}")
	public TareaDTO listarUna(@PathVariable Integer id) {
		
		TareaDTO respuesta = new TareaDTO();
		Tarea unaTarea = new Tarea();
		
		if(unaTarea == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
		}
		
		respuesta.setId(unaTarea.getId());
		respuesta.setAsignadaA(unaTarea.getAsignadaA());
		respuesta.setDescripcion(unaTarea.getDescripcion());
		respuesta.setFechaInicio(unaTarea.getFechaInicio());
		respuesta.setFechaRealizada(unaTarea.getFechaRealizada());
		respuesta.setRealizada(unaTarea.isRealizada());
	
		return respuesta;
	}
	
	@PostMapping("/")
	public TareaDTO guardar(@RequestBody TareaDTO body) {
		TareaDTO respuesta = new TareaDTO();
		Tarea tareaGuardar = new Tarea();
		
		respuesta.setAsignadaA(tareaGuardar.getAsignadaA());
		respuesta.setDescripcion(tareaGuardar.getDescripcion());
		respuesta.setFechaInicio(tareaGuardar.getFechaInicio());
		respuesta.setFechaRealizada(tareaGuardar.getFechaRealizada());
		respuesta.setRealizada(tareaGuardar.isRealizada());
		
		this.tareaRepository.save(tareaGuardar);
		
		respuesta.setId(tareaGuardar.getId());
		respuesta.setAsignadaA(tareaGuardar.getAsignadaA());
		respuesta.setDescripcion(tareaGuardar.getDescripcion());
		respuesta.setFechaInicio(tareaGuardar.getFechaInicio());
		respuesta.setFechaRealizada(tareaGuardar.getFechaRealizada());
		respuesta.setRealizada(tareaGuardar.isRealizada());
		
		
		
		
		
		return respuesta;
	}
	
	@PutMapping("/{id}")
	public TareaDTO modificar(@PathVariable Integer id, @RequestBody TareaDTO body) {
		TareaDTO respuesta = new TareaDTO();
		Tarea tareaAModificar;
		
		tareaAModificar = this.tareaRepository.findById(id).orElse(null);
		if (tareaAModificar==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " ta");
		}
		
		tareaAModificar.setAsignadaA(body.getAsignadaA());
		tareaAModificar.setDescripcion(body.getDescripcion());
		tareaAModificar.setFechaInicio(body.getFechaInicio());
		tareaAModificar.setFechaRealizada(body.getFechaRealizada());
		tareaAModificar.setRealizada(body.isRealizada());
		
		this.tareaRepository.save(tareaAModificar);
		
		return respuesta;

	}
	
	@DeleteMapping("/{id}")
	public Tarea borrar(@PathVariable Integer id) {
		
		Tarea tarea = tareaRepository.findById(id).orElse(null);
		
		if (tarea==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " ");
		}
		
		tarea.setBorrado(true);
		tareaRepository.save(tarea);
		
		return tarea;//return true??
		
		
	}
	

}
