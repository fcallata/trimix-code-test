package com.codetrimix.apptest.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codetrimix.apptest.controller.base.BaseController;
import com.codetrimix.apptest.controller.viewmodel.PersonaViewModel;
import com.codetrimix.apptest.model.dominio.Persona;
import com.codetrimix.apptest.model.dto.PersonaDTO;

@RestController
@CrossOrigin(origins = "*")
public class PersonaController extends BaseController{
	
	
	@GetMapping(value = "/personas")
	public List<PersonaDTO> getPersonas(){
		List<Persona> personas = getPersonaService().getAll();	
		return super.objectToDTO(personas);
	}
	
	@GetMapping(value = "/listaPersonas")
	public List<PersonaDTO> getPersonasByFiltro(@RequestParam("nombre") String nombre, @RequestParam("tipoDocumento") String tipoDocumento ){
		List<Persona> personas = getPersonaService().getPersonasByFiltro(nombre.toUpperCase(), tipoDocumento.toUpperCase());		
		return super.objectToDTO(personas);
	}
	
	@GetMapping(value = "/personas/{id}")
	public PersonaDTO getPersona(@PathVariable("id") Long idPersona){
		List<Persona> personas = new ArrayList<>();
		Persona persona = getPersonaService().getPersona(idPersona);
		personas.add(persona);
		List<PersonaDTO> listaPersonas = super.objectToDTO(personas);
		return listaPersonas.get(0);
	}
	
	@PostMapping(value = "/personas")
	public void createPersona(@RequestBody PersonaViewModel personaViewModel, BindingResult bindingResult){
		System.out.println("Crear Persona");
		Persona persona;
		try {			
			ZonedDateTime fecha = ZonedDateTime.parse(personaViewModel.getFechaNacimiento());
			if(bindingResult.hasErrors()){
				throw new ValidationException("No se puede crear la persona");
			}
			persona = new Persona();
			persona.setPerApellido(personaViewModel.getApellido().toUpperCase());
			persona.setPerNombre(personaViewModel.getNombre().toUpperCase());
			persona.setPerFechaNacimiento(fecha.toLocalDate());
			persona.setPerNumeroDocumento(Long.parseLong(personaViewModel.getNroDocumento()));
			persona.setPerTipoDocumento(personaViewModel.getTipoDocumento());
			getPersonaService().add(persona);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@PutMapping(value = "/personas/{id}")
	public void update(@PathVariable("id") Long idPersona, @RequestBody PersonaViewModel personaViewModel, BindingResult bindingResult){

		try {
			ZonedDateTime fecha = ZonedDateTime.parse(personaViewModel.getFechaNacimiento());
			if(bindingResult.hasErrors()){
				throw new ValidationException("No se puede crear la persona");
			}
			Persona persona = getPersonaService().getPersona(idPersona);
			persona.setPerApellido(personaViewModel.getApellido().toUpperCase());
			persona.setPerNombre(personaViewModel.getNombre().toUpperCase());
			persona.setPerFechaNacimiento(fecha.toLocalDate());
			persona.setPerNumeroDocumento(Long.parseLong(personaViewModel.getNroDocumento()));
			persona.setPerTipoDocumento(personaViewModel.getTipoDocumento());
			getPersonaService().edit(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@DeleteMapping(value = "/personas/{id}")
	public void deletePersona(@PathVariable("id") Long idPersona){		
		try {
			getPersonaService().delete(idPersona);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
	
}
