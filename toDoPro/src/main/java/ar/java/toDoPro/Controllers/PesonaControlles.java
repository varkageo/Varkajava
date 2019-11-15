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
@RequestMapping("persona")
public class PesonaControlles {
	
	//Atributos
	//Date fechaNac = new Date();
	//Date fecha = new Date();
	
	
	
	@Autowired
	private PersonaRepository personaRepository;
	
	//Metodos
	@GetMapping("/")
	public ArrayList<PersonaDTO> listarTodos() {
		
		PersonaDTO personaDTO;
		Persona unaPersona;
		
		ArrayList<PersonaDTO> respuesta = new ArrayList<PersonaDTO>();
		Iterable<Persona> listaPersonas;
		
		
		
		listaPersonas = this.personaRepository.findAll();
		System.out.println("antes del while");

		Iterator<Persona> it = listaPersonas.iterator();
		while(it.hasNext()){
		
			unaPersona = it.next();
			
			personaDTO = new PersonaDTO();
			
			personaDTO.setNombre(unaPersona.getNombre());
			personaDTO.setApellido(unaPersona.getApellido());
			
			System.out.println(personaDTO.getNombre());
			
			respuesta.add(personaDTO);
		}
		
		return respuesta;
	}
	
	
	@GetMapping("/{id}")
	public PersonaDTO listarUno (@PathVariable Integer id) {
		
		PersonaDTO respuesta = new PersonaDTO();
		Persona unaPersona = personaRepository.findById(id).orElse(null);
		
		if(unaPersona == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
		}
		
		 respuesta.setApellido(unaPersona.getApellido());
	     respuesta.setNombre(unaPersona.getNombre());
	     respuesta.setId(unaPersona.getId());

		return respuesta;
	}

	@PostMapping("/")
	public PersonaDTO guargar(@RequestBody PersonaDTO body) {
		
	PersonaDTO respuesta = new PersonaDTO();
	Persona personaGuardar = new Persona();
	
	personaGuardar.setNombre(body.getNombre());
	personaGuardar.setApellido(body.getApellido());
	
	this.personaRepository.save(personaGuardar);
	
	respuesta.setId(personaGuardar.getId());
	respuesta.setNombre(personaGuardar.getNombre());
	respuesta.setApellido(personaGuardar.getApellido());
		
	return respuesta;
	}
	
	@PutMapping("/{id}")
	public PersonaDTO modificar(@PathVariable Integer id, @RequestBody PersonaDTO body) {
		PersonaDTO respuesta = new PersonaDTO();
		Persona personaAModificar;
		
		personaAModificar = this.personaRepository.findById(id).orElse(null);
		if (personaAModificar==null) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
		}
		
		personaAModificar.setNombre(body.getNombre());
		personaAModificar.setApellido(body.getApellido());
		
		this.personaRepository.save(personaAModificar);
		
		
		return respuesta;
	}
	
	@DeleteMapping("/{id}")
	public Persona borrar(@PathVariable Integer id) {
		
		Persona persona = personaRepository.findById(id).orElse(null);
		if (persona==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pe");
		}
		
		persona.setBorrado(true);
		personaRepository.save(persona);
		
		
		
		return persona;
	}
	
	
}
