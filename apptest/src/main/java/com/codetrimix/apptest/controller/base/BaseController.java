package com.codetrimix.apptest.controller.base;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codetrimix.apptest.model.dominio.Persona;
import com.codetrimix.apptest.model.dto.PersonaDTO;
import com.codetrimix.apptest.service.PersonaService;

public class BaseController {

	@Autowired
	PersonaService personaService;
	
	public PersonaService getPersonaService(){
		return personaService;
	}
	
	public List<PersonaDTO> objectToDTO(List<Persona> personas){
		List<PersonaDTO> listaDto = new ArrayList<>();
		PersonaDTO personaDTO;
		for (Persona persona : personas) {
			personaDTO = new PersonaDTO();
			personaDTO.setPerId(persona.getPerId());
			personaDTO.setPerApellido(persona.getPerApellido());
			personaDTO.setPerNombre(persona.getPerNombre());
			personaDTO.setPerFechaNacimiento(persona.getPerFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			personaDTO.setPerTipoDocumento(persona.getPerTipoDocumento());
			personaDTO.setPerNumeroDocumento(persona.getPerNumeroDocumento());
			listaDto.add(personaDTO);
		}
		return listaDto;
	}
}
